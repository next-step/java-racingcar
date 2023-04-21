package study.racingcar.domain;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class RacingGameInputs {
    private static final int ZERO = 0;
    private static final String SPLIT_PATTERN = "[,]";

    private int numberOfGames;
    private List<String> carNames;

    public RacingGameInputs(int numberOfGames, String carNamesStr) {
        isNegativeNumberAndZero(numberOfGames);

        this.numberOfGames = numberOfGames;
        this.carNames = splitCarNameString(carNamesStr);
    }

    public int getNumberOfGames() {
        return this.numberOfGames;
    }

    public List<String> getNameOfCars() {
        return this.carNames;
    }

    private List<String> splitCarNameString(String carNameStr) {

        return Arrays.asList(carNameStr.split(SPLIT_PATTERN));
    }

    private void isNegativeNumberAndZero(int number) {

        if (number <= ZERO) {
            throw new InputMismatchException("게임 시작을 위한 세팅이 실패 하였습니다.");
        }
    }
}
