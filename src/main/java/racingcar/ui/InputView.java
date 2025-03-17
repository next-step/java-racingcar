package racingcar.ui;

import java.util.Scanner;

public class InputView {

    public static Scanner SCANNER = new Scanner(System.in);
    public static final int CAR_MIN = 0;
    public static final int NUM_MIN = 0;

    // 테스트를 위한 Scanner 설정 메소드
    public static void setScanner(Scanner scanner) {
        SCANNER = scanner;
    }

    public static int inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }
    public static int inputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }

    public static int inputValidatedNumberOfCar() {
        int input = inputNumberOfCar();
        validateInput(input, "차량 수", CAR_MIN);
        return input;
    }
    public static int inputValidatedNumberOfAttempts() {
        int input = inputNumberOfAttempts();
        validateInput(input, "시도 횟수", NUM_MIN);
        return input;
    }

    private static void validateInput(int value, String fieldName, int min) {
        if (value <= min) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %s는 %d보다 값이어야 합니다.", fieldName, min)
            );
        }
    }
}
