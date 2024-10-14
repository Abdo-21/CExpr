package com.abdo21.cexpr.operations.binop

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
internal fun BinaryOperation(
    op: String,
    modifier: Modifier = Modifier,
    withSpace: Boolean = true,
    left: @Composable () -> Unit,
    right: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        left()
        Text(text = if (withSpace) " $op " else op)
        right()
    }
}
