package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String NAME_SPLIT = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.asList(scanner.nextLine().split(NAME_SPLIT));
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return readNumber();
    }

    private int readNumber() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 입력할 수 있습니다.");
        }
    }
}
