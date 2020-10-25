package mjs.maths

fun <P1, P2, R> ((P1, P2) -> R).curry(): (P1) -> (P2) -> (R) =
    { p1: P1 -> { p2: P2 -> this(p1, p2) } }

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curry(): (P1) -> (P2) -> (P3) -> (R) =
    { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }
