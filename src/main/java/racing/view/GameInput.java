package racing.view;

public class GameInput {
    private final int playerCount;
    private final int trialCount;

    GameInput(final int playerCount, final int trialCount) {
        this.playerCount = playerCount;
        this.trialCount = trialCount;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
