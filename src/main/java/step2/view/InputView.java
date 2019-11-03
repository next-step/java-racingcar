package step2.view;

import java.util.*;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRYCOUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public static String getNameOfCars() {
        System.out.println(INPUT_NAME_MESSAGE);
        String nameOfCars = scanner.nextLine();

        return nameOfCars;
    }

    public static int getTryCount() {
        System.out.println(INPUT_TRYCOUNT_MESSAGE);
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
