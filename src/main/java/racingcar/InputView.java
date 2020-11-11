package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private final String questionCarNames = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String questionTryNumbers = "시도할 회수는 몇 회 인가요?";
    private final String COLON = " : ";

    public String[] carNames() {
        System.out.println(questionCarNames);
        return scanner.nextLine().split(COLON);
    }

    public int tryCount() {
        System.out.println(questionTryNumbers);
        return scanner.nextInt();
    }

}
