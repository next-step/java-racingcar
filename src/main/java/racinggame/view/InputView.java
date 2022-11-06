package racinggame;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String CAR_NAME_DELIMITER = ",";

    public static int requestNumber(String text) {
        System.out.println(text);
        int num = scanner.nextInt();
        validateCarNumber(num);
        return num;
    }

    private static void validateCarNumber(int input) {
        if (input <= 0) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }

    public static String[] requestCarName(String text) {
        System.out.println(text);
        return split(scanner.nextLine());
    }

    private static String[] split(String input) {
        String[] carNames = input.split(CAR_NAME_DELIMITER);
        if (carNames.length == 0) {
            throw new RuntimeException("구분자(,) 혹은 자동차 이름 수를 확인해주세요.");
        }
        return carNames;
    }
}

