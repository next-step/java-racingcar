package step4.model;

import java.util.Arrays;

public class InputData {
    private String[] players;
    private int numTry;

    public InputData(String[] players, int numTry) {
        this.players = validatePlayersName(players);
        this.numTry = validatePositiveNum(numTry);
    }

    public String[] validatePlayersName(String[] players) {
        return Arrays.stream(players)
                .peek(this::validatePlayer)
                .filter(s -> s.length() < 5)
                .toArray(String[]::new);
    }

    public void validatePlayer(String player) {
        if (player.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    public int validatePositiveNum(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("0 이거나 음수는 허용되지 않습니다.");
        }
        return value;
    }

    public String[] getPlayers() {
        return players;
    }

    public int getNumTry() {
        return numTry;
    }
}
