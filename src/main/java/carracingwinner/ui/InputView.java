package carracingwinner.ui;

import java.util.Scanner;

public class InputView {

    private static final String READ_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public String[] readCarNames() {
        System.out.println(READ_CARS_NAME_MESSAGE);
        return scanner.nextLine().split(",");
    }

    public int readTryCount() {
        System.out.println(READ_TRY_COUNT_MESSAGE);
        return scanner.nextInt();
    }

}
