package mjs.maths

import arrow.core.Eval
import kotlin.math.sqrt

fun factorsOf(number: Int): List<Int> =
    (1..sqrt(number.toDouble()).toInt() + 1)
        .filter { number % it == 0 }
        .run { this + this.map { number / it } }
        .distinct()
        .sorted()

fun aliquotSum(number: Int): Int = Eval.later {
    factorsOf(number).sum() - number
}.value()
