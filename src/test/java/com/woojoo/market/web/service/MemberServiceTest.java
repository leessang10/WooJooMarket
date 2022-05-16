package com.woojoo.market.web.service;

import com.woojoo.market.domain.member.Member;
import com.woojoo.market.repository.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    EntityManager entityManager;
    
    @Test
    void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("lee");
        // when
        Long saveMemberId = memberService.join(member);
        Member foundMember = memberRepository.findById(saveMemberId);
        // then
        assertThat(foundMember.getId()).isEqualTo(member.getId() );
        assertThat(foundMember.getName()).isEqualTo(member.getName());

    }
    @Test
    public void 이름_중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");
        // when
        memberService.join(member1);

        // then
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다.", illegalStateException.getMessage());

    }

}