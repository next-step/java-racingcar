package step_3.util;

public class GameRole {

    private final static int FORWARD_CONDITION = 4;

    private GameRole() {
    }

    public static Behavior checkRoundResult(int roundResult) {
        return roundResult >= FORWARD_CONDITION ? Behavior.FORWARD : Behavior.STOP;
    }
}
