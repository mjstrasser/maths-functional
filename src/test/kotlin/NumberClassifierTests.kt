package mjs.maths

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class NumberClassifierTests : DescribeSpec({

    describe("calculating factors") {
        it("are only 1 for 1") {
            1.factors() shouldBe listOf(1)
        }
        it("are 1 and 2 for 2") {
            2.factors() shouldBe listOf(1, 2)
        }
        it("are 1 and 3 for 3") {
            3.factors() shouldBe listOf(1, 3)
        }
        it("are 1, 2 and 4 for 4") {
            4.factors() shouldBe listOf(1, 2, 4)
        }
        it("are 1, 2, 3, 4, 6 and 12 for 12") {
            12.factors() shouldBe listOf(1, 2, 3, 4, 6, 12)
        }
        it("are only 1 and 13 for 13") {
            13.factors() shouldBe listOf(1, 13)
        }
    }

    describe("Aliquot sum") {
        it("is 0 for 1") {
            1.aliquotSum() shouldBe 0
        }
        it("is 1 for 2") {
            2.aliquotSum() shouldBe 1
        }
        it("is correct for the first 50 values") {
            // From https://en.wikipedia.org/wiki/Aliquot_sum
            listOf(0, 1, 1, 3, 1, 6, 1, 7, 4, 8,
                1, 16, 1, 10, 9, 15, 1, 21, 1, 22,
                11, 14, 1, 36, 6, 16, 13, 28, 1, 42,
                1, 31, 15, 20, 13, 55, 1, 22, 17, 50,
                1, 54, 1, 40, 33, 26, 1, 76, 8, 43).forEachIndexed { idx, sum -> (idx + 1).aliquotSum() shouldBe sum }
        }
    }

})