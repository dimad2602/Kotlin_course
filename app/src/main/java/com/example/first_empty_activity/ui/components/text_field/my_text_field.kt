package com.example.first_empty_activity.ui.components.text_field

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.first_empty_activity.ui.theme.Pink80
import com.example.first_empty_activity.ui.theme.Purple40
import com.example.first_empty_activity.ui.theme.Purple80

@Composable
fun MyTextField(
    text: MutableState<String>,
    labelText: String,
    hiddenText: Boolean? = false,
    leftIcon: ImageVector? = null,
    supportingText: String? = null,
) {
    if (leftIcon != null) {
        TextField(
            value = text.value,
            onValueChange = { newText -> text.value = newText },
            label = { Text(labelText) },
            supportingText = {
                if (supportingText != null) {
                    Text(supportingText)
                }
            },
            visualTransformation = if (hiddenText == true) PasswordVisualTransformation() else VisualTransformation.None,
            leadingIcon = {
                Icon(leftIcon, contentDescription = null, tint = Color.Blue)
            },
            trailingIcon = {
                if (text.value.isNotEmpty()) {
                    IconButton(onClick = { text.value = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = null)
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Purple40,
                unfocusedBorderColor = Color.White,
                unfocusedContainerColor = Purple80,
                focusedContainerColor = Purple80,
            ),
        )
    } else {
        OutlinedTextField(
            value = text.value,
            onValueChange = { newText -> text.value = newText },
            label = { Text(labelText) },
            supportingText = {
                if (supportingText != null) {
                    Text(supportingText)
                }
            },
            visualTransformation = if (hiddenText == true) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (text.value.isNotEmpty()) {
                    IconButton(onClick = { text.value = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = null)
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Purple40,
                unfocusedBorderColor = Color.White,
                unfocusedContainerColor = Purple80,
                focusedContainerColor = Purple80,
            ),
        )
    }
}