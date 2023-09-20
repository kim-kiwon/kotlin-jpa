package jpabook.jpashop

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class MemberRepositoryTest @Autowired constructor(
    private val memberRepository: MemberRepository
): BehaviorSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        Given("Member exists") {
            val member: Member = Member(3, "kg")

            When("MemberRepository.save") {
                val savedId = memberRepository.save(member)

                Then("DB has savedMember") {
                    val findMember = memberRepository.find(savedId)
                    findMember.id shouldBe 3
                    findMember.username shouldBe "kg"
                }
            }
        }
    }
}
