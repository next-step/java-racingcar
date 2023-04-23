package step3.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_MESSAGE_FOR_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NAME_DELIMITER = ",";
    private static final String ASK_MESSAGE_FOR_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String ERROR_MESSAGE_FOR_MINUS_COUNT = "시도할 횟수는 양수여야 합니다.";

    public static List<String> getNameOfCars() {
        System.out.println(ASK_MESSAGE_FOR_NAME_OF_CARS);
        return Arrays.asList(scanner.nextLine().split(NAME_DELIMITER));
    }

    public static int getCount() {
        System.out.println(ASK_MESSAGE_FOR_COUNT);
        int count = scanner.nextInt();
        checkIfCountPositive(count);
        return count;
    }

    private static void checkIfCountPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_MINUS_COUNT);
        }
    }

}