package racingcar.view;

import racingcar.util.ValidationUtil;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_TIME_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static String getUserInputValue(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();

        ValidationUtil.checkUserInput(inputValue);

        return inputValue;
    }

    public static String[] inputNameOfCars() {
        String[] names = getUserInputValue(INPUT_CAR_NAME_MESSAGE).split(",");
        ValidationUtil.checkCarsValidationByNames(names);
        return names;
    }

    public static String inputCountOfGame() {
        String countOfGame = getUserInputValue(INPUT_RACING_TIME_MESSAGE);
        ValidationUtil.checkCountOfGame(countOfGame);
        return countOfGame;
    }

}
