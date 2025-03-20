package com.example.myapplicationnew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationnew.ui.theme.MyApplicationNewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationNewTheme {
                    Scaffold(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 25.dp)) { innerPadding ->
                        GreetingsCardWithBgImg(
                            message = "Happy Birthday Luke!",
                            from = "From: Tommy Shelby",
                            modifier = Modifier.padding(innerPadding)
                        )

                    }
            }
        }
    }
}

@Composable
fun GreetingsText(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = from,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End),
        )
    }
    
}

@Composable
fun GreetingsCardWithBgImg(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        GreetingsText(
            message = message,
            from = from,
            modifier = Modifier.fillMaxSize()
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingsCardPreview() {
    MyApplicationNewTheme {
        GreetingsText("Happy Birthday Luke!", from = "From: Tommy Shelby")

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingsCardWithBgImgPreview() {
    MyApplicationNewTheme {
        GreetingsCardWithBgImg("Happy Birthday Luke!", "From: Tommy Shelby")

    }
}