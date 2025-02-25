package com.omarkarimli.intelliflow.ui.explore

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.omarkarimli.intelliflow.domain.models.ProductModel

@Composable
fun ExploreScreen(viewModel: ExploreViewModel) {
    var searchQuery by remember { mutableStateOf("") }
    val products by viewModel.products.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.error.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Search TextField
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                keyboardActions = KeyboardActions(onSearch = { viewModel.searchProducts(searchQuery) }),
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.extraLarge,
                singleLine = true,
                label = {
                    Text(
                        "Search for a product",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { viewModel.searchProducts(searchQuery) },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Show Loading Indicator while searching
            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator() // Loading spinner
                }
            } else if (products.isNotEmpty()) {
                // Display the product list
                LazyColumn {
                    items(products) { product ->
                        ProductItem(product)
                    }
                }
            } else if (!errorMessage.isNullOrEmpty()) {
                // Show error message if no products found or there was an error
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = errorMessage ?: "No results available", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: ProductModel) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { openProductLink(context, product.link) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(product.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Column(Modifier.padding(start = 8.dp)) {
                Text(text = product.title, fontWeight = FontWeight.Bold)
                Text(text = product.price, color = Color.Green)
            }
        }
    }
}

// Function to Open Product Link in Browser
fun openProductLink(context: android.content.Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Preview
@Composable
fun PreviewScreen() {
    ExploreScreen(ExploreViewModel())
}
