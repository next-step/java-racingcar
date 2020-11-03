package racingGame;


import racingGame.racingGameException.IllegalInputRange;

public class GameSetting {

    private final int lastRound;
    private final int numCar;

    public GameSetting(int lastRound, int numCar) {
        this.lastRound = lastRound;
        this.numCar = numCar;
    }

    public static GameSetting of(int lastRound, int numCar) {
        validateInput(lastRound);
        validateNumCar(numCar);

        return new GameSetting(lastRound, numCar);
    }

    private static void validateInput(int lastRound) {
        if (lastRound < 1) {
            throw new IllegalInputRange();
        }
    }

    private static void validateNumCar(int numCar) {
        if (numCar < 1) {
            throw new IllegalInputRange();
        }
    }

    public boolean gameFinished(int currentRound) {
        return currentRound > lastRound;
    }

    public int getNumCar() {
        return numCar;
    }

}
