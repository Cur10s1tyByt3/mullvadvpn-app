package net.mullvad.mullvadvpn.usecase

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import net.mullvad.mullvadvpn.repository.ChangelogRepository
import net.mullvad.mullvadvpn.repository.InAppNotification

class NewChangelogNotificationUseCase(private val changelogRepository: ChangelogRepository) {
    operator fun invoke() =
        changelogRepository.hasUnreadChangelog
            .map {
                buildList {
                    if (it) {
                        add(InAppNotification.NewVersionChangelog)
                    }
                }
            }
            .distinctUntilChanged()
}
