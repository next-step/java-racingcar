package step3;

import java.util.stream.IntStream;

public abstract class Game {

    private int totalRound;

    public Game(int numberOfTry) {
        this.totalRound = numberOfTry;
    }

    public void play() {
        ResultView.printResultInfoMessage();
        playAllRound();
    }

    private void playAllRound() {
        IntStream.range(0, this.totalRound).forEach(round -> playRound());
    }

    protected abstract void playRound();

}
