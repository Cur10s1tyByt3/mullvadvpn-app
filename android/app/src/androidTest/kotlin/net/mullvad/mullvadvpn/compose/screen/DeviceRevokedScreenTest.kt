package net.mullvad.mullvadvpn.compose.screen

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import de.mannodermaus.junit5.compose.ComposeContext
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.verify
import net.mullvad.mullvadvpn.compose.createEdgeToEdgeComposeExtension
import net.mullvad.mullvadvpn.compose.setContentWithTheme
import net.mullvad.mullvadvpn.compose.state.DeviceRevokedUiState
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

@OptIn(ExperimentalTestApi::class)
class DeviceRevokedScreenTest {
    @JvmField @RegisterExtension val composeExtension = createEdgeToEdgeComposeExtension()

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
    }

    private fun ComposeContext.initScreen(
        state: DeviceRevokedUiState,
        onSettingsClicked: () -> Unit = {},
        onGoToLoginClicked: () -> Unit = {},
    ) {
        setContentWithTheme {
            DeviceRevokedScreen(
                state = state,
                onSettingsClicked = onSettingsClicked,
                onGoToLoginClicked = onGoToLoginClicked,
            )
        }
    }

    @Test
    fun testUnblockWarningShowingWhenSecured() =
        composeExtension.use {
            // Arrange
            val state = DeviceRevokedUiState.SECURED

            // Act
            initScreen(state)

            // Assert
            onNodeWithText(UNBLOCK_WARNING).assertExists()
        }

    @Test
    fun testUnblockWarningNotShowingWhenNotSecured() =
        composeExtension.use {
            // Arrange
            val state = DeviceRevokedUiState.UNSECURED

            // Act
            initScreen(state)

            // Assert
            onNodeWithText(UNBLOCK_WARNING).assertDoesNotExist()
        }

    @Test
    fun testGoToLogin() =
        composeExtension.use {
            // Arrange
            val state = DeviceRevokedUiState.UNSECURED
            val mockOnGoToLoginClicked: () -> Unit = mockk(relaxed = true)
            initScreen(state = state, onGoToLoginClicked = mockOnGoToLoginClicked)

            // Act
            onNodeWithText(GO_TO_LOGIN_BUTTON_TEXT).performClick()

            // Assert
            verify { mockOnGoToLoginClicked.invoke() }
        }

    companion object {
        private const val GO_TO_LOGIN_BUTTON_TEXT = "Go to login"
        private const val UNBLOCK_WARNING =
            "Going to login will unblock the internet on this device."
    }
}
