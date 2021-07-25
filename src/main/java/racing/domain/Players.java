package racing.domain;

import java.util.Collections;
import java.util.List;

public class Players {
    public static final List<Player> EMPTY_PLAYERS = Collections.emptyList();
    private final List<Player> players;

    public Players(List<Player> player) {
        this.players = player;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isEmpty() {
        return players.isEmpty();
    }

    public static Players empty() {
        return new Players(EMPTY_PLAYERS);
    }
}
