package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    public static final String ROUNDS = "시도할 회수는 몇 회 인가요?";

    public static int askForNumberOfCars() {
        System.out.println(NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public static int askForNumberOfRounds() {
        System.out.println(ROUNDS);
        return scanner.nextInt();
    }
}
