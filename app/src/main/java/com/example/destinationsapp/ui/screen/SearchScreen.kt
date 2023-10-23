package com.example.destinationsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.destinationsapp.model.Destination
import com.example.destinationsapp.model.DestinationType
import com.example.destinationsapp.ui.theme.DestinationsAppTheme
import com.example.destinationsapp.ui.theme.kPrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navigateToDetailScreen: (Destination) -> Unit,
    filter: (String?) -> List<Destination>,
) {
    var selectedValue: String? by remember { mutableStateOf(null) }
    var filteredList: List<Destination> by remember { mutableStateOf(filter(selectedValue)) }
    Scaffold {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .padding(32.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                ) {
                    Column {
                        Text(
                            text = "Hi Brodeen!",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray,
                        )
                        Text(
                            text = "Where are you going?",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .shadow(
                                shape = RoundedCornerShape(
                                    corner = CornerSize(
                                        16.dp,
                                    ),
                                ),
                                elevation = 2.dp,
                                spotColor = Color.White,
                                ambientColor = Color.Gray,
                            ),
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notifications",
                        )
                    }
                }
                OutlinedTextField(
                    value = "",
                    onValueChange = {

                    },
                    shape = RoundedCornerShape(
                        corner = CornerSize(
                            16.dp,
                        ),
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Search your Location",
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        disabledTextColor = Color.Gray,
                        placeholderColor = Color.Gray,
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.LightGray,
                        disabledBorderColor = Color.LightGray,
                        focusedLeadingIconColor = Color.Gray,
                        unfocusedLeadingIconColor = Color.LightGray,
                        disabledLeadingIconColor = Color.LightGray,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                ) {

                    Chip(
                        setDestination = {
                            selectedValue = null
                            filteredList = filter(null)
                        },
                        isSelected = selectedValue == null,
                        text = "All",
                    )
                    Chip(
                        setDestination = {
                            selectedValue = DestinationType.Beach.name
                            filteredList = filter(DestinationType.Beach.name)
                        },
                        isSelected = selectedValue == DestinationType.Beach.name,
                        text = DestinationType.Beach.name,
                    )
                    Chip(
                        setDestination = {
                            selectedValue = DestinationType.Mountain.name
                            filteredList = filter(DestinationType.Mountain.name)
                        },
                        isSelected = selectedValue == DestinationType.Mountain.name,
                        text = DestinationType.Mountain.name,
                    )
                    Chip(
                        setDestination = {
                            selectedValue = DestinationType.Hotel.name
                            filteredList = filter(DestinationType.Hotel.name)
                        },
                        isSelected = selectedValue == DestinationType.Hotel.name,
                        text = DestinationType.Hotel.name,
                    )
                }
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                ) {
                    items(filteredList) {item ->
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .height(250.dp)
                                .shadow(
                                    elevation = 0.dp,
                                    shape = RoundedCornerShape(
                                        corner = CornerSize(
                                            16.dp,
                                        ),
                                    ),
                                    clip = true,
                                )
                                .clickable {
                                    navigateToDetailScreen(item)
                                }
                            ,
                        ) {
                            Image(
                                painter = painterResource(id = item.image),
                                contentDescription = item.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Transparent, Color.Black),
                                            startY = 500f,
                                            endY = 1000f,
                                            tileMode = TileMode.Clamp,
                                        )
                                    )
                            )
                            Column(
                                verticalArrangement = Arrangement.Bottom,
                                modifier = Modifier
                                    .matchParentSize()
                                    .padding(16.dp),
                            ) {
                                Text(
                                    text = item.name,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White,
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Location",
                                        tint = Color.Gray,
                                        modifier = Modifier.height(12.dp),
                                    )
                                    Text(
                                        text = item.location,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.Gray,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(
    setDestination: () -> Unit,
    isSelected: Boolean,
    text: String,
) {
    AssistChip(
        onClick = {
            setDestination()
        },
        label = {
            Text(
                text = text,
                modifier = Modifier.padding(vertical = 16.dp),
            )
        },
        shape = RoundedCornerShape(
            corner = CornerSize(
                16.dp
            )
        ),
        border = AssistChipDefaults.assistChipBorder(
            borderWidth = 0.dp,
            borderColor = Color.Transparent,
        ),
        colors = AssistChipDefaults.assistChipColors(
            labelColor = if (isSelected) Color.White else Color.DarkGray.copy(alpha = 0.5f),
            containerColor = if (isSelected) kPrimaryColor else Color.LightGray.copy(alpha = 0.2f),
        ),
    )
}

@Preview
@Composable
fun SearchScreenPreview() {
    DestinationsAppTheme {
        SearchScreen(
            navigateToDetailScreen = {},
            filter = { emptyList() },
        )
    }
}