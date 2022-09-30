package racingGame;

import racingGame.exception.WrongInputException;
import racingGame.view.InputVerifier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputParameters {
    private Value value;

    public InputParameters(String carNames, String tryNum) {
        value  = new Value(carNames,tryNum);
    }

    private class Value {
        private List<String> carNames;
        private int tryNum;

        private Value(String carNames, String tryNum) {
            InputVerifier.validateNameInput(carNames);
            InputVerifier.validateTryInput(tryNum);
            this.carNames = splitNames(carNames);
            this.tryNum = parseInput(tryNum);

        }

        private List<String> splitNames(String carNames) {
            return Arrays.stream(carNames.split(","))
                    .filter(this::checkNameLength)
                    .collect(Collectors.toList());
        }

        private boolean checkNameLength(String i) {
            if (i.length() > 5){
                throw new WrongInputException("5보다 큰 이름은 입력 받을 수 없습니다.");
            }
            return true;
        }

        private int getTryNum() {
            return this.tryNum;
        }

        private List<String> getCarName() {
            return carNames;
        }

        private int parseInput(String input) {
            return Integer.parseInt(input);
        }
    }

    public int getCarsSize() {
        return value.getCarName().size();
    }

    public List<String> getCarName() {
        return Collections.unmodifiableList(value.getCarName());
    }

    public int getTryNum() {
        return value.getTryNum();
    }

}
