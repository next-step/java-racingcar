package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private String qudstionCarNames = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private String questionTryNumbers = "시도할 회수는 몇 회 인가요?";

    public String[] carNames() {
        System.out.println(qudstionCarNames);
        return scanner.nextLine().split(",");
    }

    public int tryCount() {
        System.out.println(questionTryNumbers);
        return scanner.nextInt();
    }

}
