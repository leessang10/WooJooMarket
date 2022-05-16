package com.woojoo.market.domain;

import com.woojoo.market.domain.member.Member;
import com.woojoo.market.repository.member.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@Transactional
@SpringBootTest
class MemberRepositoryTest {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberRepositoryTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @AfterEach
    void after() {
    }
    @Test
    void 저장() {
        // given
        Member member = new Member();
        member.setLoginId("leessang10");
        member.setEmail("leessang10@naver.com");
        member.setPassword("qwer1234");
        member.setCreatedDate(LocalDate.now());
        // when
        memberRepository.save(member);
        Member savedMember = memberRepository.findById(member.getId());
        // then

        assertThat(savedMember.getLoginId()).isEqualTo(member.getLoginId());
        assertThat(savedMember.getEmail()).isEqualTo(member.getEmail());
        assertThat(savedMember.getPassword()).isEqualTo(member.getPassword());
    }



}