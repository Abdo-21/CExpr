package com.abdo21.cexpr.operations.binop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Equal(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit,
    right: @Composable () -> Unit,
) = BinaryOperation(
    modifier = modifier,
    op = "=",
    left = left,
    right = right
)

@Composable
fun Equal(
    modifier: Modifier = Modifier,
    left: String,
    right: String,
) = Equal(
    modifier = modifier,
    left = {
        Text(text = left)
    },
    right = {
        Text(text = right)
    }
)

@Composable
fun Equal(
    modifier: Modifier = Modifier,
    left: String,
    right: @Composable () -> Unit,
) = Equal(
    modifier = modifier,
    left = {
        Text(text = left)
    },
    right = right
)

@Composable
fun Equal(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit,
    right: String
) = Equal(
    modifier = modifier,
    left = left,
    right = {
        Text(text = right)
    }
)

@Preview(showBackground = true)
@Composable
private fun PlusPreview1() {
    Equal(
        left = {
            Text(text = "a")
        },
        right = {
            Text(text = "159")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview2() {
    Equal(
        left = "a",
        right = "159"
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview3() {
    Equal(
        left = "a",
        right = {
            Text(text = "159")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview4() {
    Equal(
        left = {
            Text(text = "a")
        },
        right = "159"
    )
}
