package com.woojoo.market.domain.member;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String postcode;
    private String address;
    private String detailAddress;
    private String extraAddress;

    // 외부에서 그냥 인스턴스 호출 못하도록 방지
    protected Address() {
    }

    public Address(String postcode, String address, String detailAddress, String extraAddress) {
        this.postcode = postcode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;
    }
}
