package com.example.demo.discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) // enum 형은 = 두개 쓰는게 맞음
        {
            return discountFixAmount;
        }
        else{
            return 0;
        }
    }
}
