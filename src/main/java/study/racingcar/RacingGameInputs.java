package study.racingcar;

import java.util.InputMismatchException;

public class RacingGameInputs {
    private static final int ZERO = 0;
    private static final int FIVE = 5;
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

        String[] splitCarName = carNameStr.split(SPLIT_PATTERN);

        for(String carName : splitCarName) {
            isMoreThanFiveLength(carName);
        }

        return splitCarName;
    }

    private void isNegativeNumberAndZero(int number) {

        if(number <= ZERO) {
            throw new InputMismatchException("게임 시작을 위한 세팅이 실패 하였습니다.");
        }
    }

    private void isMoreThanFiveLength(String name) {

        if(name.length() > FIVE) {
            throw new InputMismatchException("자동차 이름이 5글자가 넘었습니다.");
        }
    }
}
