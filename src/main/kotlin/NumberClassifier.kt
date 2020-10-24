package mjs.maths

import kotlin.math.sqrt

fun factorsOf(number: Int): List<Int> =
    (1..sqrt(number.toDouble()).toInt() + 1)
        .filter { number % it == 0 }
        .run { this + this.map { number / it } }
        .distinct()
        .sorted()
