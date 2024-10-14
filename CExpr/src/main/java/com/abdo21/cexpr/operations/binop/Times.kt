package com.abdo21.cexpr.operations.binop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

enum class SignType {
    Cross, Dot, NONE
}

@Composable
fun Times(
    modifier: Modifier = Modifier,
    signType: SignType = SignType.Cross,
    withSpace: Boolean = signType == SignType.Cross,
    left: @Composable () -> Unit,
    right: @Composable () -> Unit,
) = BinaryOperation(
    modifier = modifier,
    op = when(signType) {
        SignType.Cross -> "x"
        SignType.Dot -> "."
        SignType.NONE -> ""
    },
    withSpace = withSpace,
    left = left,
    right = right
)

@Composable
fun Times(
    modifier: Modifier = Modifier,
    signType: SignType = SignType.Cross,
    left: String,
    right: String,
) = Times(
    signType = signType,
    modifier = modifier,
    left = {
        Text(text = left)
    },
    right = {
        Text(text = right)
    }
)

@Composable
fun Times(
    modifier: Modifier = Modifier,
    signType: SignType = SignType.Cross,
    left: String,
    right: @Composable () -> Unit,
) = Times(
    signType = signType,
    modifier = modifier,
    left = {
        Text(text = left)
    },
    right = right
)

@Composable
fun Times(
    modifier: Modifier = Modifier,
    signType: SignType = SignType.Cross,
    left: @Composable () -> Unit,
    right: String
) = Times(
    signType = signType,
    modifier = modifier,
    left = left,
    right = {
        Text(text = right)
    }
)

@Preview(showBackground = true)
@Composable
private fun PlusPreview1() {
    Times(
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
    Times(
        left = "12",
        right = "159"
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview3() {
    Times(
        left = "12",
        right = {
            Text(text = "159")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview4() {
    Times(
        signType = SignType.Dot,
        left = {
            Text(text = "12")
        },
        right = "159"
    )
}

@Preview(showBackground = true)
@Composable
private fun PlusPreview5() {
    Times(
        signType = SignType.NONE,
        left = {
            Text(text = "2")
        },
        right = "a"
    )
}
