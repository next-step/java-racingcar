package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_MESSAGE= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final String DELIMITER = ",";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public List<String> inputCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
        return Arrays.asList(scanner.nextLine().split(DELIMITER));
    }

    public int inputRoundCount() {
        System.out.println(ROUND_COUNT_MESSAGE);
        return scanner.nextInt();
    }

}
