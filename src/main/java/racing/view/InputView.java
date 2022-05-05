package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);
    static final String CAR_NAME_DELIMITER = ",";

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.next();
        List<String> carNames = Arrays.asList(input.split(CAR_NAME_DELIMITER));
        return carNames;
    }

    public int inputMoveNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
