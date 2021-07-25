package racingcar.view;

import racingcar.util.ValidationUtil;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_RACING_TIME_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static int getUserInputValue(String message) {
        System.out.println(message);

        Scanner sc = new Scanner(System.in);
        String userInputValue = sc.nextLine();
        ValidationUtil.checkUserInput(userInputValue);

        return Integer.parseInt(userInputValue);
    }

    public static int inputCountOfCar() {
        int countOfCar = getUserInputValue(INPUT_CAR_COUNT_MESSAGE);
        ValidationUtil.checkCountOfCar(countOfCar);

        return countOfCar;
    }

    public static int inputCountOfGame() {
        int countOfGame = getUserInputValue(INPUT_RACING_TIME_MESSAGE);
        ValidationUtil.checkCountOfGame(countOfGame);
        return countOfGame;
    }

}
