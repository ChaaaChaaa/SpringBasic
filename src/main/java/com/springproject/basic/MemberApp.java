package com.springproject.basic;

import com.springproject.basic.member.Grade;
import com.springproject.basic.member.Member;
import com.springproject.basic.member.MemberService;
import com.springproject.basic.member.MemberServiceImpl;
import com.springproject.basic.order.Order;
import com.springproject.basic.order.OrderService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",20000);
        System.out.println("order = "+order);
    }
}
