package com.abdo21.cexpr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdo21.cexpr.operations.Fraction
import com.abdo21.cexpr.operations.Parenthesis
import com.abdo21.cexpr.operations.Power
import com.abdo21.cexpr.operations.SquareRoot
import com.abdo21.cexpr.operations.binop.Plus
import com.abdo21.cexpr.ui.theme.CExprTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CExprTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        App()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun App(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Fraction(
            numerator = {
                Plus(
                    left = {
                        Parenthesis(
                            content = {
                                Plus(
                                    left = {
                                        SquareRoot(
                                            content = {
                                                Fraction(
                                                    numerator = {
                                                        Plus(left = "125", right = "14")
                                                    },
                                                    denominator = "2"
                                                )
                                            }
                                        )
                                    },
                                    right = "159"
                                )
                            }
                        )
                    },
                    right = {
                        Power(base = "2", exponent = "3")
                    }
                )
            },
            denominator = {
                Fraction(numerator = "1", denominator = "2")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))

        Fraction(
            numerator = {
                Plus(
                    left = {
                        Fraction(numerator = "1", denominator = "2")
                    },
                    right = {
                        Fraction(numerator = "1", denominator = "265")
                    }
                )
            },
            denominator = {
                Fraction(numerator = "1", denominator = "2345")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))

        SquareRoot(
            content = {
                Plus(left = "12", right = "78")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))

        SquareRoot(
            content = {
                Fraction(numerator = "12", denominator = "78")
            }
        )
    }
}
