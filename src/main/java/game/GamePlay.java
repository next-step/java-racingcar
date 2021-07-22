package game;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {

    private final List<Player> players;
    private final Validation validation;

    public GamePlay() {
        players = new ArrayList<>();
        validation = new Validation();
    }

    public List<Player> createPlayer(String playerListValue) {
        String[] playerArray = stringToStringArray(playerListValue);
        validation.validStringEmpty(stringByTrim(playerListValue));
        return setupPlayer(playerArray);
    }

    public List<Player> setupPlayer(String[] playerArray) {
        int CHECK_LENGTH = 4;
        for (String playerName : playerArray) {
            validation.validStringLength(playerName, CHECK_LENGTH);
            Player player = new Player(playerName);
            players.add(player);
        }
        return players;
    }

    public String[] stringToStringArray(String value) {
        return value.split(",");
    }

    public String stringByTrim(String value) {
        return value.trim();
    }
}

