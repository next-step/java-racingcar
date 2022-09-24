package racingGame;

import racingGame.exception.NegativeExceptionV1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameInput {
    private List<Integer> inputs = new ArrayList<>();

    public GameInput(String carNum, String tryNum) {
        validateNegative(carNum);
        validateNegative(tryNum);
        this.inputs.add(parseInput(carNum));
        this.inputs.add(parseInput(tryNum));
    }

    private int parseInput(String input) {
        return Integer.parseInt(input);
    }

    private void validateNegative(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new NegativeExceptionV1("0보단 큰 숫자를 입력해주세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInput gameInput = (GameInput) o;
        return Objects.equals(inputs, gameInput.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs);
    }
}
