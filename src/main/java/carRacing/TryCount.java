package carRacing;

public class TryCount {

    private final RacingGame racingGame;
    private final int value;

    public TryCount(int value, RacingGame racingGame) {
        this.value = value;
        this.racingGame = racingGame;
    }

    public int value() {
        return value;
    }

    public void playGame() {
        for (int i = 0; i < value(); i++) {
            racingGame.playGame();
            ResultView.printResult(racingGame.getRacingCars());
        }
    }
}
