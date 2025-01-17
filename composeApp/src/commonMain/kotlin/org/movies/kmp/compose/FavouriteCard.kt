package org.movies.kmp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.movies.kmp.favourites.domain.model.FavouriteProgram

@Composable
fun FavouriteCard(
    modifier: Modifier = Modifier,
    program: FavouriteProgram,
    onClick: (FavouriteProgram) -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(200.dp)
            .height(400.dp)
            .clickable { onClick(program) },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box {
            CoilImage(
                imageModel = { program.image },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(4.dp)),
            )
            Text(
                text = program.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(MaterialTheme.colorScheme.surface)
                    .fillMaxWidth()
                    .padding(8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}