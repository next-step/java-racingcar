package view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final int MAX_NAME_LENGTH = 5;

    private InputView() {
    }

    public static int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }

    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = splitBySeparate(SCANNER.nextLine());
        validateCarName(carNames);
        return carNames;
    }

    public static void validateCarName(String[] carNames) {
        for (String carName : carNames) {
            checkCarNameLength(carName);
        }
    }

    private static String[] splitBySeparate(String carNames) {
        return carNames.split(",");
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
