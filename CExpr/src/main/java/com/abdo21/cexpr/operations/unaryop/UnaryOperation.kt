package com.abdo21.cexpr.operations.unaryop

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun UnaryOperation(
    operation: String,
    modifier: Modifier = Modifier,
    right: @Composable () -> Unit
) {
    Row(modifier = modifier) {
        Text(text = operation)
        right()
    }
}



