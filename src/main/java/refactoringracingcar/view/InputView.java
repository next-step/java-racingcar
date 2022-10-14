package refactoringracingcar.view;

import racingcarwinnerexception.NameIsEmptyNullException;
import refactoringracingcar.racingexception.ExceptionCommand;
import refactoringracingcar.racingexception.InputValueException;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_GAME_NUMBER = "시도할 회수는 몇회인가요?";
    private static final int MIN_GAME_NUMBER = 1;
    private static Scanner sc = new Scanner(System.in);
    private static ExceptionCommand exceptionCommand = new ExceptionCommand();

    public static String enterCarName() {
        System.out.println(INPUT_CAR_NAME);
        String carName = sc.nextLine();
        validateNullValue(carName);
        return carName;
    }

    private static void validateNullValue(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new InputValueException(exceptionCommand.NULL_EXCEPTION_MESSAGE);
        }
        if (carNames.charAt(carNames.length() - 1) == ',') {
            throw new NameIsEmptyNullException("자동차 이름은 빈값이 들어올 수 없습니다.");
        }
    }

    public static int enterGameNumber() {
        System.out.println(INPUT_GAME_NUMBER);
        int gameNumber = sc.nextInt();
        validateGameNumber(gameNumber);
        return gameNumber;
    }

    private static void validateGameNumber(int gameNumber) {
        if (gameNumber < MIN_GAME_NUMBER) {
            throw new InputValueException(exceptionCommand.NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
