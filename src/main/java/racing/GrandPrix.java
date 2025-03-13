package racing;

public class GrandPrix {
    private final int totalRound;
    private int playedRound;

    public GrandPrix(int totalRound) {
        this.totalRound = totalRound;
        this.playedRound = 0;
    }

    public boolean isFinished() {
        return playedRound == totalRound;
    }

    public void play() {
        playedRound++;
    }
}
