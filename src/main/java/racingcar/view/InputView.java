package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String MSG_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MSG_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private static final String NAME_SPLIT_KEYWORD = ",";

    public List<String> inputCarNames() {
        System.out.println(MSG_CARS);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        List<String> carNames = Arrays.asList(input.split(NAME_SPLIT_KEYWORD));
        return carNames;
    }

    public int inputNumberOfAttempts() {
        System.out.println(MSG_ATTEMPTS);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
