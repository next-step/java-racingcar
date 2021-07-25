package racing.view;

import racing.domain.CarNameException;
import racing.domain.Players;
import racing.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputCarPlayer {
    private static final String PLAYER_SEPARATOR = ",";

    public static Players createPlayers(String inputValue) throws CarNameException {
        return new Players(makePlayer(inputValue));
    }

    protected static List<Player> makePlayer(String inputValue) throws CarNameException {
        return Arrays.stream(split(inputValue)).map(Player::new).collect(Collectors.toList());
    }

    private static String[] split(String inputValue) {
        return inputValue.split(PLAYER_SEPARATOR);
    }
}
