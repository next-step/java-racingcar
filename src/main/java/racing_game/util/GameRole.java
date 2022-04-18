package racing_game.util;

public class GameRole {

    private static final int FORWARD_CONDITION = 4;

    private GameRole() {
    }

    public static Behavior checkRoundResult(int roundResult) {
        return roundResult >= FORWARD_CONDITION ? Behavior.FORWARD : Behavior.STOP;
    }
}
