package com.example.sas15_ite393_socialmedia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sas15_ite393_socialmedia.ui.theme.SAS15_ITE393_SOCIALMEDIATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            SAS15_ITE393_SOCIALMEDIATheme {
                ShareScreen()
            }
        }
    }
}

@Composable
fun ShareScreen() {
    val context = LocalContext.current
    Surface(modifier = Modifier) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ShareButton(context, "Android Oreo: https://www.youtube.com/watch?v=B6nhmJ-o01Y")
        }
    }
}


@Composable
fun ShareButton(context: Context, text: String) {
    Button(
        onClick = {
            shareContent(context, text)
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(66.dp)
    ) {
        Text(text = "Share Link")
    }
}

fun shareContent(context: Context, text: String) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
}

@Preview(showBackground = true)
@Composable
fun PreviewShareScreen() {
    ShareScreen()
}
