package jpabook.jpashop.service

import jpabook.jpashop.domain.Member
import jpabook.jpashop.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    // 회원 가입
    @Transactional
    fun join(member: Member): Long {
        validateDuplicateMember(member) // 중복 회원 검증
        memberRepository.save(member)
        return member.id
    }

    private fun validateDuplicateMember(member: Member) {
        // Exception
        val findMembers = memberRepository.findByName(member.name)
        if (findMembers.isNotEmpty()) {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }

    @Transactional(readOnly = true)
    // 회원 전체 조회
    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun findOne(memberId: Long): Member {
        return memberRepository.findOne(memberId)
            ?: throw IllegalArgumentException("해당 멤버가 존재하지 않습니다. memberId: $memberId")
    }
}
