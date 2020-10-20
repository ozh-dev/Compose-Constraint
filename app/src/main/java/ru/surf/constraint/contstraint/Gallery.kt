package ru.surf.constraint.contstraint

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewGalleryView() {
    GalleryView()
}

@Composable
fun GalleryView() {
    ConstraintLayout() {
        Box(modifier = Modifier.background(color = Color.Blue).size(56.dp))
    }
}