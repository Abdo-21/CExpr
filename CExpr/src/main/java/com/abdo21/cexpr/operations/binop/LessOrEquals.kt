package com.abdo21.cexpr.operations.binop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun LessOrEquals(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit,
    right: @Composable () -> Unit,
) = BinaryOperation(
    modifier = modifier,
    op = "≤",
    left = left,
    right = right
)

@Composable
fun LessOrEquals(
    modifier: Modifier = Modifier,
    left: String,
    right: String,
) = LessOrEquals(
    modifier = modifier,
    left = {
        Text(text = left)
    },
    right = {
        Text(text = right)
    }
)

@Composable
fun LessOrEquals(
    modifier: Modifier = Modifier,
    left: String,
    right: @Composable () -> Unit,
) = LessOrEquals(
    modifier = modifier,
    left = {
        Text(text = left)
    },
    right = right
)

@Composable
fun LessOrEquals(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit,
    right: String
) = LessOrEquals(
    modifier = modifier,
    left = left,
    right = {
        Text(text = right)
    }
)

@Preview(showBackground = true)
@Composable
private fun PlusPreview1() {
    LessOrEquals(
        left = {
            Text(text = "12")
        },
        right = {
            Text(text = "159")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview2() {
    LessOrEquals(
        left = "12",
        right = "159"
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview3() {
    LessOrEquals(
        left = "12",
        right = {
            Text(text = "159")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview4() {
    LessOrEquals(
        left = {
            Text(text = "12")
        },
        right = "159"
    )
}
