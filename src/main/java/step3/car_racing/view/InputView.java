package step3.car_racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String VALIDATION_MESSAGE = "양수만 입력할 수 있습니다. 다시 입력해 주세요.";
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACING_SIZE_REQUEST_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Integer ZERO = 0;

    private InputView() {
        // 인스턴스화 방지
        throw new AssertionError();
    }

    public static List<String> inputCarNameList() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
        return makeNameList();
    }

    public static int inputRacingSize() {
        System.out.println(RACING_SIZE_REQUEST_MESSAGE);
        return convertInputStringToInteger();
    }

    private static int convertInputStringToInteger() {
        String input = SCANNER.next();

        while (!validatePositive(input)) {
            System.out.println(VALIDATION_MESSAGE);
            input = SCANNER.next();
        }

        return Integer.parseInt(input);
    }

    private static boolean validatePositive(String input) {
        try {
            return Integer.parseInt(input) > ZERO;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<String> makeNameList() {
        return Arrays.stream(SCANNER.nextLine().trim().split(",")).collect(Collectors.toList());
    }
}
