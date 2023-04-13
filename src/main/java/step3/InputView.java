package step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_MESSAGE_FOR_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_MESSAGE_FOR_COUNT = "시도할 회수는 몇 회 인가요?";

    public static String getNameOfCars() {
        System.out.println(ASK_MESSAGE_FOR_NAME_OF_CARS);
        return scanner.nextLine();
    }

    public static int getCount() {
        System.out.println(ASK_MESSAGE_FOR_COUNT);
        return scanner.nextInt();
    }

}