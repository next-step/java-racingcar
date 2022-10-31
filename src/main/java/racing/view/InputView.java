package racing.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String NOT_NUMBER_FORMAT_MESSAGE = "숫자 이외의 값이 포함되어 있습니다.";
    private static final String NOT_POSITIVVE_MESSAGE = "음수가 포함되어 있습니다.";

    private static final String NOT_EXCEED_CARNAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";

    private static final String SPLIT_REGEX = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public String[] getCarNames() {
        String[] carNames = inputCarName().split(SPLIT_REGEX);
        return removeWhiteSpace(carNames);
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public String inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }

    private String[] removeWhiteSpace(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .toArray(String[]::new);
    }
}
