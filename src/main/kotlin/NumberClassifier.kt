package mjs.maths

fun factorsOf(number: Int): List<Int> = (1 .. number)
    .filter { number % it == 0 }
