package mjs.maths

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class NumberClassifierTests : DescribeSpec({

    describe("calculating factors") {
        it("are only 1 for 1") {
            1.factors() shouldBe setOf(1)
        }
        it("are 1 and 2 for 2") {
            2.factors() shouldBe setOf(1, 2)
        }
        it("are 1 and 3 for 3") {
            3.factors() shouldBe setOf(1, 3)
        }
        it("are 1, 2 and 4 for 4") {
            4.factors() shouldBe setOf(1, 2, 4)
        }
        it("are 1, 2, 3, 4, 6 and 12 for 12") {
            12.factors() shouldBe setOf(1, 2, 3, 4, 6, 12)
        }
        it("are only 1 and 13 for 13") {
            13.factors() shouldBe setOf(1, 13)
        }
    }

    describe("Aliquot sum") {
        it("is 0 for 1") {
            1.aliquotSum() shouldBe 0
        }
        it("is 1 for 2") {
            2.aliquotSum() shouldBe 1
        }
        it("is calculated correctly for the first 50 values") {
            // From https://en.wikipedia.org/wiki/Aliquot_sum
            listOf(
                0, 1, 1, 3, 1, 6, 1, 7, 4, 8,
                1, 16, 1, 10, 9, 15, 1, 21, 1, 22,
                11, 14, 1, 36, 6, 16, 13, 28, 1, 42,
                1, 31, 15, 20, 13, 55, 1, 22, 17, 50,
                1, 54, 1, 40, 33, 26, 1, 76, 8, 43
            ).forEachIndexed { idx, sum -> (idx + 1).aliquotSum() shouldBe sum }
        }
    }

    describe("Perfect numbers are equal to their Aliquot sums") {
        it("6 is a perfect number") {
            6.isPerfect() shouldBe true
        }
        it("5 is not a perfect number") {
            5.isPerfect() shouldBe false
        }
        it("28 is a perfect number") {
            28.isPerfect() shouldBe true
        }
    }

    describe("Deficient numbers are greater than their Aliquot sums") {
        it("12 is deficient") {
            13.isDeficient() shouldBe true
        }
        it("is evaluated correctly for the first 20 values") {
            // From https://en.wikipedia.org/wiki/Deficient_number
            setOf(1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 19, 21, 22, 23, 25)
                .forEach { int -> int.isDeficient() shouldBe true }
        }
    }

    describe("Abundant numbers are less than their Aliquot sums") {
        it("12 is abundant") {
            12.isAbundant() shouldBe true
        }
        it("is evaluated correctly for the first 20 values") {
            // From https://en.wikipedia.org/wiki/Abundant_number
            setOf(12, 18, 20, 24, 30, 36, 40, 42, 48, 54, 56, 60, 66, 70, 72, 78, 80, 84, 88, 90)
                .forEach { int -> int.isAbundant() shouldBe true }
        }
    }

})