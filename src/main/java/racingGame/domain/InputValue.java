package racingGame.domain;

import racingGame.InputVerifier;
import racingGame.exception.WrongInputException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputValue {
    private final List<String> carNames;
    private final int tryNum;

    public InputValue(String carNames, String tryNum) {
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
        if (i.length() > 5) {
            throw new WrongInputException("5보다 큰 이름은 입력 받을 수 없습니다.");
        }
        return true;
    }

    public int getTryNum() {
        return this.tryNum;
    }

    public List<String> getCarName() {
        return Collections.unmodifiableList(carNames);
    }

    public int getCarsSize() {
        return this.carNames.size();
    }

    private int parseInput(String input) {
        return Integer.parseInt(input);
    }
}