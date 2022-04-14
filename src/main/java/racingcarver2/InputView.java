package racingcarver2;

import racingcar.RacingCar;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String  CAR_NUMBER_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String  TRY_NUMBER_QUESTION = "시도할 회수는 몇 회 인가요?";

    public static void show() {
        int carNumber = InputStringValidator.valid(enterTheNumberOfCars());

        int tryNumber = InputStringValidator.valid(enterTheNumberOfTry());

        RacingGame.start(carNumber, tryNumber);
    }

    private static String enterTheNumberOfCars() {
        System.out.println(CAR_NUMBER_QUESTION);
        return scanner.nextLine();
    }

    private static String enterTheNumberOfTry() {
        System.out.println(TRY_NUMBER_QUESTION);
        return scanner.nextLine();
    }

}
