package mjs.maths

import kotlin.math.sqrt

fun Int.factors(): List<Int> =
    (1..sqrt(this.toDouble()).toInt() + 1)
        .filter { this % it == 0 }
        .let { facts -> facts + facts.map { fact -> this / fact } }
        .distinct()
        .sorted()

fun Int.aliquotSum(): Int = this.factors().sum() - this

fun Int.isPerfect(): Boolean = this.aliquotSum() == this

fun Int.isDeficient(): Boolean = this.aliquotSum() < this

fun Int.isAbundant(): Boolean = this.aliquotSum() > this
