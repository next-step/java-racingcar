package step3;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_FOR_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_FOR_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public int inputCarCount() {
        System.out.println(QUESTION_FOR_CAR_COUNT);
        return inputCount();
    }

    public int inputTryCount() {
        System.out.println(QUESTION_FOR_TRY_COUNT);
        return inputCount();
    }

    public int inputCount() {
        int count = scanner.nextInt();
        if (count <= 0) {
            throw new RuntimeException("1 이상의 숫자를 입력 받아야 합니다.");
        }
        return count;
    }
}
