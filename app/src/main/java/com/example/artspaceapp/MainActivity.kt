package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {

                ArtSpaceApp()
            }
        }
    }
}
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier, ){

    var currentIndex by remember { mutableStateOf(0)}

    val image = listOf(
        R.drawable.albino_rattlesnake_wallpaper_1920x1080,
        R.drawable.animals_7_wallpaper_1920x1080,
        R.drawable.asiatic_reticulated_python_wallpaper_1920x1080,
        R.drawable.beautiful_gumprechts_green_pit_viper_trimeresurus_gumprechti_snake_wallpaper_1920x1080,
        R.drawable.beautiful_angry_lion_wallpaper_1920x1080,
        R.drawable.black_horse_5_wallpaper_1920x1080,
    )

    val Nom = listOf(

        "Python reticule",
        "Python Albinos",
        "Viper verte",
        "Horse sauvage",
        "Lion enrage"
    )
    Column (Modifier.shadow(25.dp)) {
        Column {
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center) {

            val image = painterResource(image[currentIndex])

                Image(painter = image, contentDescription = "Animal Description")

            }

            Text (text = Nom[currentIndex],
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp).fillMaxSize())
        }
    }

    Row (horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.Bottom){

        Button (onClick = {
            if (currentIndex > 0) {

            } }) {

            Text(text = "Preview")
        }

        Button(onClick = {
            if ( currentIndex < image.lastIndex) {

                currentIndex ++

            } }) {

            Text(text = "Next")
        }

    }

}


