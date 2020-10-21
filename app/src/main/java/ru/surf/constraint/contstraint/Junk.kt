package ru.surf.constraint.contstraint

import androidx.compose.foundation.layout.ConstraintSet

val cs = ConstraintSet {
    val viewReference = createRefFor(LayoutId(index = 0))

    constrain(viewReference) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
    }
}