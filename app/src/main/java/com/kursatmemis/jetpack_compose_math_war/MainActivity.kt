package com.kursatmemis.jetpack_compose_math_war

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    Column(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .background(MaterialTheme.colorScheme.tertiary),
    ) {

        HalfScreenContent(isTopScreen = true)
        HalfScreenContent(isTopScreen = false)

    }
}

@Composable
fun HalfScreenContent(isTopScreen: Boolean) {
    val backgroundColor: Int
    val textColor: Color
    val modifier: Modifier

    if (isTopScreen) {
        backgroundColor = R.color.light_blue
        textColor = colorResource(id = R.color.sky_blue)

        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(1f)
            .padding(top = 100.dp)
            .rotate(180.0f)
    } else {
        backgroundColor = R.color.light_red
        textColor = colorResource(id = R.color.cherry_red)
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
            .padding(bottom = 100.dp)
            .rotate(0.0f)
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        OperationText(number1 = "33", number2 = "11", operation = "*")

        Divider(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(start = 10.dp, end = 10.dp),
            thickness = 10.dp,
            color = textColor
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OptionText(option = 10.toString(), backgroundColor, textColor)
            OptionText(option = 123.toString(), backgroundColor, textColor)
            OptionText(option = 66.toString(), backgroundColor, textColor)
        }

    }

}

@Composable
fun OperationText(number1: String, number2: String, operation: String) {
    Box(
        modifier = Modifier.fillMaxWidth(1f),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$number1 $operation $number2",
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            color = Color.White
        )
    }
}

@Composable
fun OptionText(option: String, backgroundColor: Int, textColor: Color) {
    Text(
        text = option,
        fontSize = 44.sp,
        textAlign = TextAlign.Center,
        color = textColor,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        modifier = Modifier
            .background(colorResource(id = backgroundColor), RoundedCornerShape(35.dp))
            .border(6.dp, textColor, RoundedCornerShape(35.dp))
            .padding(9.dp)
            .height(60.dp)
            .width(90.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}



