package study.racingcar.domain;

import java.util.InputMismatchException;

public class RacingGameInputs {
    private static final int ZERO = 0;
    private static final String SPLIT_PATTERN = "[,]";

    private int numberOfGames;
    private String[] carNameArray;

    public RacingGameInputs(int numberOfGames, String carNamesStr) {
        isNegativeNumberAndZero(numberOfGames);

        this.numberOfGames = numberOfGames;
        this.carNameArray = splitCarNameString(carNamesStr);
    }

    public int getNumberOfGames() {
        return this.numberOfGames;
    }

    public String[] getNameOfCars() {
        return this.carNameArray;
    }

    private String[] splitCarNameString(String carNameStr) {

        return carNameStr.split(SPLIT_PATTERN);
    }

    private void isNegativeNumberAndZero(int number) {

        if (number <= ZERO) {
            throw new InputMismatchException("게임 시작을 위한 세팅이 실패 하였습니다.");
        }
    }
}
