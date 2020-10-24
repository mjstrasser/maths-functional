package mjs.maths

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class NumberClassifierTests : DescribeSpec({

    describe("calculating factors") {
        it("are only 1 for 1") {
            factorsOf(1) shouldBe listOf(1)
        }
        it("are 1 and 2 for 2") {
            factorsOf(2) shouldBe listOf(1, 2)
        }
        it("are 1 and 3 for 3") {
            factorsOf(3) shouldBe listOf(1, 3)
        }
        it("are 1, 2 and 4 for 4") {
            factorsOf(4) shouldBe listOf(1, 2, 4)
        }
        it("are 1, 2, 3, 4, 6 and 12 for 12") {
            factorsOf(12) shouldBe listOf(1, 2, 3, 4, 6, 12)
        }
        it("are only 1 and 13 for 13") {
            factorsOf(13) shouldBe listOf(1, 13)
        }
    }

})