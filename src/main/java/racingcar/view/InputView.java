package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_INPUT_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_INPUT_TRY_COUNT = "시도할 회수는 몇 회인가요?";

    public static int getNumberOfCars() {
        System.out.println(MESSAGE_INPUT_NUMBER_OF_CARS);
        return inputNumberFromUser();
    }
    
    public static int getTryCount() {
        System.out.println(MESSAGE_INPUT_TRY_COUNT);
        return inputNumberFromUser();
    }

    private static int inputNumberFromUser() {
        return SCANNER.nextInt();
    }

}
