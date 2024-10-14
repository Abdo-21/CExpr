package com.abdo21.cexpr.operations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abdo21.cexpr.utils.toDp
import kotlin.math.max


@Composable
fun Fraction(
    modifier: Modifier = Modifier,
    fractionLineThickness: Dp = 1.dp,
    fractionColor: Color = Color.Black,
    numerator: @Composable () -> Unit,
    denominator: @Composable () -> Unit
) {
    var numeratorWidth by remember { mutableIntStateOf(0) }
    var denominatorWidth by remember { mutableIntStateOf(0) }

    val fractionWidth = remember(numeratorWidth, denominatorWidth) {
        max(numeratorWidth, denominatorWidth)
    }

    val padding =  8.dp

    // Measure the widest text (numerator or denominator)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        // Numerator
        Box(modifier = Modifier.onSizeChanged { numeratorWidth = it.width }) {
            numerator()
        }

        // Fraction line
        HorizontalDivider(
            modifier = Modifier
                .width(padding + fractionWidth.toDp()),
            color = fractionColor,
            thickness = fractionLineThickness
        )

        // Denominator
        Box(modifier = Modifier.onSizeChanged { denominatorWidth = it.width }) {
            denominator()
        }
    }
}

@Composable
fun Fraction(
    modifier: Modifier = Modifier,
    fractionLineThickness: Dp = 1.dp,
    fractionColor: Color = Color.Black,
    numerator: String,
    denominator: String
) = Fraction(
    modifier = modifier,
    fractionLineThickness = fractionLineThickness,
    fractionColor = fractionColor,
    numerator = {
        Text(text = numerator)
    },

    denominator = {
        Text(text = denominator)
    }
)

@Composable
fun Fraction(
    modifier: Modifier = Modifier,
    fractionLineThickness: Dp = 1.dp,
    fractionColor: Color = Color.Black,
    numerator: @Composable () -> Unit,
    denominator: String
) = Fraction(
    modifier = modifier,
    fractionLineThickness = fractionLineThickness,
    fractionColor = fractionColor,
    numerator = numerator,
    denominator = {
        Text(text = denominator)
    }
)

@Composable
fun Fraction(
    modifier: Modifier = Modifier,
    fractionLineThickness: Dp = 1.dp,
    fractionColor: Color = Color.Black,
    numerator: String,
    denominator: @Composable () -> Unit,
) = Fraction(
    modifier = modifier,
    fractionLineThickness = fractionLineThickness,
    fractionColor = fractionColor,
    numerator = {
        Text(text = numerator)
    },
    denominator = denominator
)

@Preview(showBackground = true)
@Composable
fun FractionPreview1() {
    Fraction(
        numerator = {
            Text(text = "1")
        },
        denominator = {
            Text(text = "1234")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun FractionPreview2() {
    Fraction(
        numerator = "1",
        denominator = "1234"
    )
}

@Preview(showBackground = true)
@Composable
fun FractionPreview3() {
    Fraction(
        numerator = "1",
        denominator = {
            Text(text = "1234")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun FractionPreview4() {
    Fraction(
        numerator = {
            Text(text = "1")
        },
        denominator = "1234"
    )
}

@Preview(showBackground = true)
@Composable
fun FractionPreview5() {
    Fraction(
        numerator = {
            Fraction(
                numerator = {
                    Text(text = "1")
                },
                denominator = "2"
            )
        },
        denominator = {
            Fraction(
                numerator = {
                    Text(text = "1")
                },
                denominator = "2"
            )
        }
    )
}
