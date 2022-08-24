package com.springproject.basic;

import com.springproject.basic.member.Grade;
import com.springproject.basic.member.Member;
import com.springproject.basic.member.MemberService;
import com.springproject.basic.member.MemberServiceImpl;
import com.springproject.basic.order.Order;
import com.springproject.basic.order.OrderService;
import com.springproject.basic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);
        System.out.println("order = "+order);
    }
}
