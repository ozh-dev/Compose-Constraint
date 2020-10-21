package ru.surf.constraint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import ru.surf.constraint.contstraint.GalleryView
import ru.surf.constraint.ui.ComposeConstraintTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pictures = Array(36) { "https://picsum.photos/400" }.asList()
        setContent {
            ScrollableColumn {
                pictures
                    .chunked(6)
                    .forEachIndexed { index, urls ->
                        GalleryView(
                            urls = urls,
                            isLtr = index % 2 == 0
                        )
                    }
            }
        }
    }
}