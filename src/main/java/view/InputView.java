package view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_FOR_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String[] inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return SCANNER.nextLine().split(CAR_NAME_SEPARATOR);
    }

    public static int inputTryCount() {
        System.out.println(QUESTION_FOR_TRY_COUNT);
        int tryCount = SCANNER.nextInt();
        if (tryCount <= 0) {
            throw new RuntimeException("1 이상의 숫자를 입력 받아야 합니다.");
        }
        return tryCount;
    }
}


