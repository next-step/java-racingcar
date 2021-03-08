package racingcar;

public class InputManagement {

    private static String[] carNames;
    private static int countRound;

    public InputManagement(String[] carNames, int countRound) {
        this.carNames = carNames;
        this.countRound = countRound;
    }

    public static int getCountRound() {
        return countRound;
    }

    public static String[] getCarNames() {
        return carNames;
    }
}
