package com.springproject.basic;

import com.springproject.basic.discount.DiscountPolicy;
import com.springproject.basic.discount.FixDiscountPolicy;
import com.springproject.basic.discount.RateDiscountPolicy;
import com.springproject.basic.member.MemberService;
import com.springproject.basic.member.MemberServiceImpl;
import com.springproject.basic.member.MemoryMemberRepository;
import com.springproject.basic.order.OrderService;
import com.springproject.basic.order.OrderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
