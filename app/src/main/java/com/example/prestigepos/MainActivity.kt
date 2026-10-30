package com.example.prestigepos

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prestigepos.ui.theme.PrestigePOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrestigePOSTheme {
                Box (modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp,vertical = 25.dp)) {
                    MenuTitle(name = "Prestige POS")
                    POSMenu(mapOf("Cake" to 2.0f, "Bread" to 1.56f, "Chicken" to 7.85f))
                }
            }
        }
    }
}
@Composable
fun MenuTitle(name: String) {
    Row (verticalAlignment = Alignment.Bottom,) {
        Text (
            text = name,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun POSMenu(items: Map<String, Float>) {
    var offsetV: Int = 0
    var offsetH: Int = 0
    var cardCount: Int = 0
    for (item in items.entries.iterator()) {
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.dp, androidx.compose.ui.graphics.Color(Color.BLACK)),
            modifier = Modifier.padding(horizontal = ((cardCount%2)*120).dp,vertical = offsetV.dp).size(width = 110.dp, height = 75.dp)
        ) {
            Text(
                text = "%s".format(item.key),
                modifier = Modifier.padding(vertical = 6.dp, horizontal = 6.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Price: $%.2f".format(item.value),
                modifier = Modifier.padding(horizontal = 6.dp),
                textAlign = TextAlign.Center
            )
        }
        cardCount = cardCount + 1
    }
}