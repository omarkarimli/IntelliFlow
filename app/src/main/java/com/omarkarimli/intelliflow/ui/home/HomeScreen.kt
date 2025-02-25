package com.omarkarimli.intelliflow.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omarkarimli.intelliflow.ui.theme.gradientColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = { Text("") },
                actions = {
                    IconButton(
                        modifier = Modifier.padding(8.dp),
                        onClick = { /* TODO: Navigate to settings */ }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                "Hi Jeremy,\nHow can I help\nyou today?",
                style = MaterialTheme.typography.headlineLarge.copy(
                    brush = Brush.linearGradient(
                        colors = gradientColors
                    ),
                    fontSize = 42.sp
                ),
                modifier = Modifier.fillMaxWidth().padding(top = 64.dp)
            )

        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    HomeScreen(HomeViewModel())
}
