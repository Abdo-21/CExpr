package com.abdo21.cexpr.operations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun Power(
    modifier: Modifier = Modifier,
    base: @Composable () -> Unit,
    exponent: @Composable () -> Unit
) {
    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .alignBy {
                    0
                }
        ) {
            base()
        }
        Box(
            modifier = Modifier
                .alignBy {
                    0
                }
        ) {
            CompositionLocalProvider(LocalTextStyle provides TextStyle(fontSize = 7.sp)) {
                exponent()
            }
        }
    }
//    Layout(
//        modifier = modifier,
//        content = {
//            Box(Modifier.layoutId("base")) {
//                base()
//            }
//            Box(Modifier.layoutId("exponent")) {
//                exponent()
//            }
//        }
//    ) { measurables, constraints ->
//
//        val basePlaceable = measurables.first { it.layoutId == "base" }.measure(constraints)
//        val exponentPlaceable = measurables.first { it.layoutId == "exponent" }.measure(constraints)
//
//        val layoutWidth = basePlaceable.width + exponentPlaceable.width
//        val layoutHeight = 3*basePlaceable.height/2 + exponentPlaceable.height
//
//        // Set the layout size and position the children
//        layout(layoutWidth, layoutHeight) {
//            basePlaceable.placeRelative(0, exponentPlaceable.height)
//            exponentPlaceable.placeRelative(basePlaceable.width, 0)
//        }
//    }
}


@Composable
fun Power(
    modifier: Modifier = Modifier,
    base: String,
    exponent: String
) = Power(
    modifier = modifier,
    base = {
        Text(text = base)
    },
    exponent = {
        Text(text = exponent)
    }
)

@Composable
fun Power(
    modifier: Modifier = Modifier,
    base: String,
    exponent: @Composable () -> Unit
) = Power(
    modifier = modifier,
    base = {
        Text(text = base)
    },
    exponent = exponent
)

@Composable
fun Power(
    modifier: Modifier = Modifier,
    base: @Composable () -> Unit,
    exponent: String
) {
    Power(
        modifier = modifier,
        base = base,
        exponent = {
            Text(text = exponent)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PowerRenderPreview() {
    Power(
        base = {
            Text(text = "1265")
        },
        exponent = "2"
    )
}
