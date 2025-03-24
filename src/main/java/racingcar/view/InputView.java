package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getCarCount() {
        return validatePositiveInt(scanInt("자동차 대수는 몇 대 인가요?"));
    }

    public int getRunCount() {
        return validatePositiveInt(scanInt("시도할 회수는 몇 회 인가요?"));
    }

    private int scanInt(String message) {
        System.out.println(message);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private int validatePositiveInt(int value) {
        if (value <= 0) {
            String errorMessage = String.format("입력 값은 양수여야 합니다. value:%d", value);
            throw new IllegalArgumentException(errorMessage);
        }
        return value;
    }

}