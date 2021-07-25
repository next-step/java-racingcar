package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String MSG_CARS="경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MSG_ATTEMPTS="시도할 회수는 몇 회 인가요?";

    public List<String> inputCarNames() {
        System.out.println(MSG_CARS);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return Arrays.asList(input.split(","));
    }

    public int inputNumberOfAttempts() {
        System.out.println(MSG_ATTEMPTS);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
