package racingCar.domain;

public class NumberOfGame {
    public static final int GAME_OVER_NUMBER = 0;

    private int numberOfGame;

    public NumberOfGame(int numberOfGame) {
        this.numberOfGame = numberOfGame;
    }

    public boolean isEndGame() {
        return this.numberOfGame == GAME_OVER_NUMBER;
    }

    public void decreaseNumberOfGame() {
        this.numberOfGame--;
    }

    public boolean checkNumberOfGame(int numberOfGame) {
        return this.numberOfGame == numberOfGame;
    }
}
