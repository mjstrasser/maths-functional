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

    describe("Aliquot sum") {
        it("is 0 for 1") {
            aliquotSum(1) shouldBe 0
        }
        it("is 1 for 2") {
            aliquotSum(2) shouldBe 1
        }
        it("is correct for the first 50 values") {
            // From https://en.wikipedia.org/wiki/Aliquot_sum
            listOf(0, 1, 1, 3, 1, 6, 1, 7, 4, 8,
                1, 16, 1, 10, 9, 15, 1, 21, 1, 22,
                11, 14, 1, 36, 6, 16, 13, 28, 1, 42,
                1, 31, 15, 20, 13, 55, 1, 22, 17, 50,
                1, 54, 1, 40, 33, 26, 1, 76, 8, 43).forEachIndexed { idx, sum -> aliquotSum(idx + 1) shouldBe sum }
        }
    }

})