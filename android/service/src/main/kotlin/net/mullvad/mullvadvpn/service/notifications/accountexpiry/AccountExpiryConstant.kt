@file:Suppress("MagicNumber")

package net.mullvad.mullvadvpn.service.notifications.accountexpiry

import kotlin.time.Duration.Companion.seconds
import org.joda.time.Duration

val ACCOUNT_EXPIRY_POLL_INTERVAL = 15.seconds
val ACCOUNT_EXPIRY_IN_APP_NOTIFICATION_UPDATE_INTERVAL: Duration = Duration.standardDays(1)
val ACCOUNT_EXPIRY_CLOSE_TO_EXPIRY_THRESHOLD: Duration = Duration.standardDays(3)

val ACCOUNT_EXPIRY_ANDROID_NOTIFICATION_UPDATE_INTERVAL_LONG: Duration = Duration.standardDays(1)
val ACCOUNT_EXPIRY_ANDROID_NOTIFICATION_UPDATE_INTERVAL_SHORT: Duration = Duration.standardHours(1)
val ACCOUNT_EXPIRY_ANDROID_NOTIFICATION_UPDATE_INTERVAL_SHORT_THRESHOLD: Duration =
    Duration.standardDays(1)
