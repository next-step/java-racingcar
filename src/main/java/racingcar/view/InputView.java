package racingcar.view;

import racingcar.util.ValidationUtil;

import java.util.Scanner;

public class InputView {

    private final String CAR_NUMBER_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private final String RACING_TIME_MESSAGE = "시도할 회수는 몇회인가요?";

    private int getUserInputValue(String message) {
        System.out.println(message);

        Scanner sc = new Scanner(System.in);
        String userInputValue = sc.nextLine();
        ValidationUtil.checkUserInput(userInputValue);

        return Integer.parseInt(userInputValue);
    }

    public int inputNumberOfCar() {
        int numberOfCar = getUserInputValue(CAR_NUMBER_MESSAGE);
        ValidationUtil.checkNumberOfCar(numberOfCar);

        return numberOfCar;
    }

    public int inputNumberOfGame() {
        return getUserInputValue(RACING_TIME_MESSAGE);
    }

}
