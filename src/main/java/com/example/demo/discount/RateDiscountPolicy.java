package com.example.demo.discount;

import com.example.demo.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRate = 10;

    @Override
    public int discount(Member member, int price) {
        return price* discountRate / 100;
    }
}
