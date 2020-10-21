package ru.surf.constraint.contstraint

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.coil.CoilImage

@Preview
@Composable
fun PreviewGalleryView() {
    GalleryView(
        Array(6){""}.asList(),
        false
    )
}

@Composable
fun GalleryView(urls: List<String>, isLtr: Boolean) {
    WithConstraints {

        val containerSize = min(this.maxWidth, this.maxHeight)
        val bigPictureSize = containerSize * (2 / 3f)
        val smallPictureSize = containerSize * (1 / 3f)

        ConstraintLayout(
            modifier = Modifier.size(containerSize),
            constraintSet = buildConstraintSet(urls.size, isLtr)
        ) {
            urls.forEachIndexed { index, url ->
                Picture(
                    id = LayoutId(index = index),
                    size = if (index == 0) bigPictureSize else smallPictureSize,
                    url = url
                )
            }
        }
    }
}

@Composable
fun Picture(id: Any, size: Dp, url: String) {
    Surface(
        modifier = Modifier
            .layoutId(id)
            .size(size)
            .padding(2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        CoilImage(data = url)
    }
}

private fun buildConstraintSet(viewCount: Int, isLtr: Boolean): ConstraintSet {
    return ConstraintSet {
        (0 until viewCount).forEach { index ->
            constrain(index, isLtr)
        }
    }
}

private fun ConstraintSetScope.constrain(viewIndex: Int, isLtr: Boolean) {
    constrain(createRefFor(LayoutId(viewIndex))) {
        when (viewIndex) {
            0 -> {
                top.linkTo(parent.top)
                if(!isLtr) {
                    end.linkTo(parent.end)
                }
            }
            1 -> {
                top.linkTo(parent.top)
                if (isLtr) {
                    end.linkTo(parent.end)
                }
            }
            2 -> {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                if (isLtr) {
                    end.linkTo(parent.end)
                }
            }
            3 -> {
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            4 -> {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            5 -> {
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        }
    }
}