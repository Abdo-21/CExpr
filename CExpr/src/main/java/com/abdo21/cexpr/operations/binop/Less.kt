package com.abdo21.cexpr.operations.binop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Less(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit,
    right: @Composable () -> Unit,
) = BinaryOperation(
    modifier = modifier,
    op = "<",
    left = left,
    right = right
)

@Composable
fun Less(
    modifier: Modifier = Modifier,
    left: String,
    right: String,
) = Less(
    modifier = modifier,
    left = {
        Text(text = left)
    },
    right = {
        Text(text = right)
    }
)

@Composable
fun Less(
    modifier: Modifier = Modifier,
    left: String,
    right: @Composable () -> Unit,
) = Less(
    modifier = modifier,
    left = {
        Text(text = left)
    },
    right = right
)

@Composable
fun Less(
    modifier: Modifier = Modifier,
    left: @Composable () -> Unit,
    right: String
) = Less(
    modifier = modifier,
    left = left,
    right = {
        Text(text = right)
    }
)

@Preview(showBackground = true)
@Composable
private fun PlusPreview1() {
    Less(
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
    Less(
        left = "12",
        right = "159"
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview3() {
    Less(
        left = "12",
        right = {
            Text(text = "159")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview4() {
    Less(
        left = {
            Text(text = "12")
        },
        right = "159"
    )
}
