package racingcar.dto;

public class InputManagement {

    private String[] carNames;
    private int countRound;

    public InputManagement(String[] carNames, int countRound) {
        this.carNames = carNames;
        this.countRound = countRound;
    }

    public int getCountRound() {
        return countRound;
    }

    public String[] getCarNames() {
        return carNames;
    }
}
