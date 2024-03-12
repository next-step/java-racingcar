package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return List.of(
            scanner.nextLine().split(CAR_NAMES_DELIMITER)
        );
    }

    public int inputRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
        return scanner.nextInt();
    }
}
