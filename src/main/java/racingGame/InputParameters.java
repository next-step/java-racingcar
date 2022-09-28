package racingGame;

import racingGame.view.InputVerifier;

import java.util.Objects;

public class InputParameters {
    private Input carNum;
    private Input tryNum;

    public InputParameters(String carNum, String tryNum) {
        this.carNum = new Input(carNum);
        this.tryNum = new Input(tryNum);
    }

    public class Input {
        private int input;

        public Input(String inputNum) {
            InputVerifier.validateInput(inputNum);
            this.input = parseInput(inputNum);
        }

        public int getInput() {
            return this.input;
        }

        private int parseInput(String input) {
            return Integer.parseInt(input);
        }
    }

    public int getCarNum() {
        return carNum.getInput();
    }

    public int getTryNum() {
        return tryNum.getInput();
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
