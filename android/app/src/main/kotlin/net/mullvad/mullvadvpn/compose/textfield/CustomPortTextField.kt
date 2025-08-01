package net.mullvad.mullvadvpn.compose.textfield

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import net.mullvad.mullvadvpn.R

@Composable
fun CustomPortTextField(
    value: String,
    modifier: Modifier = Modifier,
    onSubmit: (String) -> Unit,
    onValueChanged: (String) -> Unit,
    isValidValue: Boolean,
    maxCharLength: Int,
) {
    CustomTextField(
        value = value,
        keyboardType = KeyboardType.Number,
        modifier = modifier,
        onValueChanged = onValueChanged,
        onSubmit = onSubmit,
        placeholderText = stringResource(id = R.string.custom_port_dialog_placeholder),
        maxCharLength = maxCharLength,
        isValidValue = isValidValue,
        isDigitsOnlyAllowed = true,
        textStyle = MaterialTheme.typography.titleMedium,
    )
}
