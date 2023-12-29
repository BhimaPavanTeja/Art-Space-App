package com.example.artspaceapp

import android.os.Bundle
import android.support.v4.os.IResultReceiver2.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Gallery()
                }
            }
        }
    }
}


@Composable
fun Gallery() {
    var photo by remember { mutableIntStateOf(1) }

    @Composable
    fun Screen(image: Int, @StringRes title: Int, @StringRes author: Int) {
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 50.dp)
                .fillMaxSize()
        ) {
            Button(onClick = { photo -= 1 }, modifier = Modifier.padding(5.dp)) {
                Text(text = "Previous", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.padding(end = 40.dp))
            Button(onClick = { photo += 1 }, modifier = Modifier.padding(5.dp)) {
                Text(text = "Next", fontSize = 16.sp)
            }
        }

        Column {
            Image(painter = painterResource(id = image), contentDescription = "Forest",
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 100.dp, start = 100.dp, end = 100.dp)
                    .border(
                        3.dp,
                        Color.DarkGray,
                        RoundedCornerShape(1)
                    )
            )
            Column(
                modifier = Modifier
                    .border(
                        3.dp,
                        Color.DarkGray,
                        RoundedCornerShape(15)
                    )
                    .padding(15.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = title), fontStyle = FontStyle.Italic, fontSize = 30.sp, color = Color.Black)
                Text(text = stringResource(id = author), fontSize = 20.sp, color = Color.Black)
            }
        }
    }

    when(photo) {
        0 -> photo = 3
        1 -> Screen(R.drawable.forest_01, R.string.forest, R.string.des1)
        2 -> Screen(R.drawable.desktop_02, R.string.desktop, R.string.des2)
        3 -> Screen(R.drawable.gaming_03, R.string.gaming, R.string.des3)
        4 -> photo = 1
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        Gallery()
    }
}