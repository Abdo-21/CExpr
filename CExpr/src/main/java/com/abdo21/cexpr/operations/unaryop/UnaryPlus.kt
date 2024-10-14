package com.abdo21.cexpr.operations.unaryop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun UnaryPlus(
    modifier: Modifier = Modifier,
    right: @Composable () -> Unit
) = UnaryOperation(
    modifier = modifier,
    right = right,
    operation = "+"
)

@Composable
fun UnaryPlus(
    modifier: Modifier = Modifier,
    right: String
) = UnaryPlus(
    modifier = modifier,
    right = { Text(text = right) }
)


@Preview(showBackground = true)
@Composable
private fun UnaryPlusPreview() {
    UnaryPlus(
        right = "12"
    )
}

@Preview(showBackground = true)
@Composable
private fun UnaryPlusPreview2() {
    UnaryPlus(
        right = {
            Text(text = "12")
        }
    )
}