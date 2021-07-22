package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_INPUT_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";

    public static int getNumberOfCars() {
        System.out.println(MESSAGE_INPUT_NUMBER_OF_CARS);
        return SCANNER.nextInt();
    }

}
