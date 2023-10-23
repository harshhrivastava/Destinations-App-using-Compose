package com.example.destinationsapp.ui.screen

import android.content.Context
import android.util.TypedValue
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.destinationsapp.model.Destination
import com.example.destinationsapp.ui.theme.kPrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    onNavigateBack: () -> Unit,
    clickedLike: () -> Unit,
    selectedDestination: Destination,
    context: Context,
) {
    val scrollState = rememberScrollState()
    var selectedInfo by remember { mutableStateOf(selectedDestination.description) }
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = MaterialTheme.typography.headlineMedium.toSpanStyle().copy(
                fontWeight = FontWeight.SemiBold,
            ),
        ) {
            append("$${selectedDestination.totalPricePerPerson}")
        }
        withStyle(
            style = MaterialTheme.typography.bodyMedium.toSpanStyle().copy(
                color = Color.Gray,
            ),
        ) {
            append("/Person")
        }
    }
    Scaffold {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Column {
                Box {
                    Box(
                        modifier = Modifier
                            .height(300.dp)
                    ) {
                        Image(
                            painter = painterResource(id = selectedDestination.image),
                            contentDescription = selectedDestination.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth(),
                        )
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(Color.Transparent)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.Top,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(32.dp),
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(48.dp)
                                        .width(48.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .matchParentSize()
                                            .clip(CircleShape)
                                            .background(Color.White.copy(alpha = 0.4f))
                                            .blur(16.dp)
                                    )
                                    IconButton(
                                        onClick = {
                                            onNavigateBack()
                                        },
                                        colors = IconButtonDefaults.iconButtonColors(
                                            contentColor = Color.White,
                                            containerColor = Color.Transparent,
                                        ),
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowBack,
                                            contentDescription = "Back Button",
                                            tint = Color.White,
                                        )
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .height(48.dp)
                                        .width(48.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .matchParentSize()
                                            .clip(CircleShape)
                                            .background(Color.White.copy(alpha = 0.4f))
                                            .blur(16.dp)
                                    )
                                    IconButton(
                                        onClick = {
                                            clickedLike()
                                        },
                                        colors = IconButtonDefaults.iconButtonColors(
                                            contentColor = Color.White,
                                            containerColor = Color.Transparent,
                                        ),
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Favorite,
                                            contentDescription = "Like Button",
                                            tint = if (selectedDestination.isFav) {
                                                Color.Red
                                            } else {
                                                Color.White
                                            },
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color.White),
                                    startY = TypedValue.applyDimension(
                                        TypedValue.COMPLEX_UNIT_DIP,
                                        200f,
                                        context.resources.displayMetrics,
                                    ),
                                    endY = TypedValue.applyDimension(
                                        TypedValue.COMPLEX_UNIT_DIP,
                                        300f,
                                        context.resources.displayMetrics,
                                    ),
                                )
                            ),
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                    ) {
                        Column {
                            Text(
                                text = selectedDestination.name,
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 8.dp),
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "Location",
                                    tint = Color.Gray,
                                )
                                Text(
                                    text = selectedDestination.location,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray,
                                )
                            }
                        }
                        Text(
                            text = annotatedString,
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                    ) {
                        Chip(
                            setDestination = {},
                            isSelected = false,
                            text = "${selectedDestination.totalNumberOfDays} Days",
                        )
                        Chip(
                            setDestination = {},
                            isSelected = false,
                            text = "${selectedDestination.stars} Ratings",
                        )
                        if (selectedDestination.withGuide) {
                            Chip(
                                setDestination = {},
                                isSelected = false,
                                text = "With Guide",
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 16.dp)
                            .fillMaxWidth(),
                    ) {
                        Text(
                            text = "Description",
                            style = MaterialTheme.typography.titleLarge,
                            color = if (selectedInfo == selectedDestination.description) {
                                kPrimaryColor
                            } else {
                                Color.Gray
                            },
                            textDecoration = if (selectedInfo == selectedDestination.description) {
                                TextDecoration.Underline
                            } else {
                                TextDecoration.None
                            },
                            modifier = Modifier
                                .clickable {
                                    selectedInfo = selectedDestination.description
                                }
                                .padding(horizontal = 8.dp)
                        )
                        Text(
                            text = "Reviews",
                            style = MaterialTheme.typography.titleLarge,
                            color = if (selectedInfo == "${selectedDestination.stars} Ratings") {
                                kPrimaryColor
                            } else {
                                Color.Gray
                            },
                            textDecoration = if (selectedInfo == "${selectedDestination.stars} Ratings") {
                                TextDecoration.Underline
                            } else {
                                TextDecoration.None
                            },
                            modifier = Modifier
                                .clickable {
                                    selectedInfo = "${selectedDestination.stars} Ratings"
                                }
                                .padding(horizontal = 8.dp)
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 16.dp)
                                .fillMaxWidth(),
                        ) {
                            Text(
                                text = selectedInfo,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray,
                                textAlign = TextAlign.Justify,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            if (scrollState.value == 0) {
                                Box(
                                    modifier = Modifier
                                        .matchParentSize()
                                        .background(
                                            Brush.verticalGradient(
                                                colors = listOf(Color.Transparent, Color.White),
                                                startY = TypedValue.applyDimension(
                                                    TypedValue.COMPLEX_UNIT_DIP,
                                                    200f,
                                                    context.resources.displayMetrics,
                                                ),
                                                endY = TypedValue.applyDimension(
                                                    TypedValue.COMPLEX_UNIT_DIP,
                                                    300f,
                                                    context.resources.displayMetrics,
                                                ),
                                            )
                                        ),
                                )
                            }
                        }
                    }
                }
                OutlinedButton(
                    onClick = {

                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = kPrimaryColor,
                        contentColor = Color.White,
                    ),
                    border = BorderStroke(
                        width = 0.dp,
                        color = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Book Now",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                }
            }
        }
    }
}