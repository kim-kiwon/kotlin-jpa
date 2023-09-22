package jpabook.jpashop.repository

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import jpabook.jpashop.domain.Member
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class MemberRepositoryTest(
    private val memberRepository: MemberRepository
): BehaviorSpec() {

    init {
        Given("ready for memberRepository test") {
            val member = Member(name="testName")
            val member2 = Member(name="testName2")

            memberRepository.save(member)
            memberRepository.save(member2)

            When("memberRepository.findOne") {
                val foundMember = memberRepository.findOne(member.id)

                Then("find member from DB") {
                    foundMember shouldBe member
                }
            }

            When("memberRepository.findAll") {
                val foundMembers = memberRepository.findAll()

                Then("find member and member2 from DB") {
                    foundMembers.shouldContain(member)
                    foundMembers.shouldContain(member2)
                }
            }

            When("memberRepository.findByName") {
                val foundMember = memberRepository.findByName("testName")

                Then("find member from DB") {
                    foundMember.shouldContain(member)
                }
            }
        }
    }
}
