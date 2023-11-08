package step3.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_ASK_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_ASK_NUMBER_OF_TRY = "시도할 회수는 몇 회 인가요?";

    public static String nameOfCars() {
        System.out.println(MESSAGE_ASK_NAME_OF_CARS);
        return scanner.nextLine();
    }

    public static int numberOfTry() {
        System.out.println(MESSAGE_ASK_NUMBER_OF_TRY);
        return scanner.nextInt();
    }

}
