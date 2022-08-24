package com.springproject.basic.discount;

import com.springproject.basic.annotaion.MainDiscountPolicy;
import com.springproject.basic.member.Grade;
import com.springproject.basic.member.Member;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
//@Primary //Rate가 무조건 먼저 선택되도록 할때
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price*discountPercent / 100;
        }else{
            return 0;
        }
    }
}
