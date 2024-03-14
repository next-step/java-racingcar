package racinggame.view;

import java.util.Scanner;

public class InputView {
    public static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String TRY_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public String inputCarsName() {
        System.out.println(CAR_NAME_QUESTION);
        return scanner.nextLine();
    }

    public int inputTryCount() {
        System.out.println(TRY_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
