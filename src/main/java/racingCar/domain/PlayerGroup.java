package racingCar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerGroup {
    private final List<Player> playerGroup;

    public PlayerGroup(List<Player> playerGroup) {
        this.playerGroup = playerGroup;
    }

    public static PlayerGroup from(List<String> playerGroup) {
        return new PlayerGroup(convertToPlayerGroup(playerGroup));
    }

    private static List<Player> convertToPlayerGroup(List<String> playerGroup) {
        return playerGroup.stream()
                .map(Player::from)
                .collect(Collectors.toUnmodifiableList());
    }
}
