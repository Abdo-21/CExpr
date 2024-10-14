package com.abdo21.cexpr.operations.unaryop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun UnaryMinus(
    modifier: Modifier = Modifier,
    right: @Composable () -> Unit
) = UnaryOperation(
    modifier = modifier,
    right = right,
    operation = "-"
)

@Composable
fun UnaryMinus(
    right: String,
    modifier: Modifier = Modifier
) = UnaryMinus(
    modifier = modifier,
    right = { Text(text = right) }
)

@Preview(showBackground = true)
@Composable
private fun UnaryMinusPreview() {
    UnaryMinus(
        right = "12"
    )
}

@Preview(showBackground = true)
@Composable
private fun UnaryMinusPreview2() {
    UnaryMinus(
        right = {
            Text(text = "12")
        }
    )
}