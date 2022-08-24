package com.springproject.basic.order;

import com.springproject.basic.annotaion.MainDiscountPolicy;
import com.springproject.basic.discount.DiscountPolicy;
import com.springproject.basic.discount.FixDiscountPolicy;
import com.springproject.basic.discount.RateDiscountPolicy;
import com.springproject.basic.member.Member;
import com.springproject.basic.member.MemberRepository;
import com.springproject.basic.member.MemoryMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    //주문 생성 요청이 오면 회원정보 조회를 하고 할인정책에다가 넘김
    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정 할인 정책
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
