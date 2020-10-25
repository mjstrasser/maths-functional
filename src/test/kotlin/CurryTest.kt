package mjs.maths

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CurryTest : DescribeSpec({

    describe("curry()") {
        it("two-parameter function") {
            val append = { a: String, b: String -> "$a $b" }
            val curried = append.curry()
            curried("one")("two") shouldBe "one two"
            val curr1 = curried("this")
            curr1("that") shouldBe "this that"
        }
        it("three-parameter function") {
            val threePar = { a: Int, b: Int, c: Int -> a * b + c }
            val curried = threePar.curry()
            curried(2)(3)(4) shouldBe 10
            val curr1 = curried(2)
            val curr2 = curr1(3)
            curr2(4) shouldBe 10
        }
    }

})