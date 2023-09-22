package jpabook.jpashop.service

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import jpabook.jpashop.domain.Member
import jpabook.jpashop.repository.MemberRepository
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class MemberServiceTest: BehaviorSpec() {

    private val memberRepository = mock<MemberRepository>()
    private val memberService = MemberService(memberRepository)

    init {
        Given("ready for memberService test") {
            val member = Member(name="testName")

            And("member is exist in DB") {
                whenever(memberRepository.findByName("testName")).thenReturn(listOf(member))

                When("memberService.join") {
                    val action = {
                        memberService.join(member)
                    }

                    Then("exception is thrown") {
                        shouldThrow<IllegalStateException>(action)
                    }
                }
            }
        }
    }
}
