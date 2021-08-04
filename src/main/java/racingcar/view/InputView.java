package racingcar.view;

import racingcar.exception.InvalidCarSettingException;
import racingcar.exception.InvalidUserInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_TIME_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final String INVALID_STRING_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INVALID_GAME_COUNT_MESSAGE = "1회 이상의 게임 횟수를 입력해야 시작 가능합니다.";
    private static final String INVALID_BLANK_STRING_MESSAGE = "공백은 입력이 불가합니다.";

    private static final String INVALID_DUPLICATE_CAR_NAME_MESSAGE = "중복된 자동차가 있습니다.";
    private static final String INVALID_BLANK_CAR_NAME_MESSAGE = "자동차 이름은 공백이 불가합니다.";
    private static final String INVALID_LENGTH_CAR_NAME_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String INVALID_CAR_COUNT_MESSAGE = "2개 이상의 자동차를 입력해야 시작 가능합니다.";

    private static String getUserInputValue(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();

        checkUserInput(inputValue);

        return inputValue;
    }

    public static List<String> inputNameOfCars() {
        List<String> names = Arrays.asList(getUserInputValue(INPUT_CAR_NAME_MESSAGE).split(","));
        checkCarsValidation(names);
        return names;
    }

    public static String inputCountOfGame() {
        String countOfGame = getUserInputValue(INPUT_RACING_TIME_MESSAGE);
        checkCountOfGame(countOfGame);
        return countOfGame;
    }


    private static void checkUserInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidUserInputException(INVALID_BLANK_STRING_MESSAGE);
        }
    }

    private static void checkCarsValidation(List<String> names) {
        checkBlankCarName(names);
        checkLengthCarName(names);
        checkDuplicateCar(names);
        checkCountOfCar(names);
    }

    private static void checkBlankCarName(List<String> names) {
        if (names.stream().anyMatch(n -> n == null || n.trim().isEmpty())) {
            throw new InvalidCarSettingException(INVALID_BLANK_CAR_NAME_MESSAGE);
        }
    }

    private static void checkLengthCarName(List<String> names) {
        if (names.stream().anyMatch(n -> n.length() > 5)) {
            throw new InvalidCarSettingException(INVALID_LENGTH_CAR_NAME_MESSAGE);
        }
    }

    private static void checkDuplicateCar(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new InvalidCarSettingException(INVALID_DUPLICATE_CAR_NAME_MESSAGE);
        }
    }

    private static void checkCountOfCar(List<String> names) {
        if (names.size() <= 1) {
            throw new InvalidCarSettingException(INVALID_CAR_COUNT_MESSAGE);
        }
    }

    private static void checkCountOfGame(String racingTime) {
        if (checkNumberValidation(racingTime) < 1) {
            throw new InvalidUserInputException(INVALID_GAME_COUNT_MESSAGE);
        }
    }

    private static int checkNumberValidation(String StrNumber) {
        try {
            Integer.parseInt(StrNumber);
        } catch (NumberFormatException e) {
            throw new InvalidUserInputException(INVALID_STRING_MESSAGE);
        }

        return Integer.parseInt(StrNumber);
    }
}
