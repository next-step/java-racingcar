package racingGame;

import racingGame.view.InputVerifier;

import java.util.Objects;

public class InputParameters {
    private int carNum;
    private int tryNum;
    public InputParameters(String carNum, String tryNum) {
        InputVerifier.validateInput(carNum,tryNum);
        this.carNum = parseInput(carNum);
        this.tryNum  = parseInput(tryNum);
    }

    private int parseInput(String input) {
        return Integer.parseInt(input);
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTryNum() {
        return tryNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputParameters that = (InputParameters) o;
        return carNum == that.carNum && tryNum == that.tryNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNum, tryNum);
    }
}
