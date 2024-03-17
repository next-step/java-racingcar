package step4.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static step4.util.MyPrinter.printLine;

public class RacingInputView {
    private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String EMPTY_STRING = "";
    private static final Scanner SCANNER = new Scanner(System.in);

    private RacingInputView() {
    }

    public static List<String> carNames() {
        printLine(CAR_NAMES_QUESTION);
        return splitCarNames(SCANNER.nextLine());
    }

    private static List<String> splitCarNames(String input) {
        return Arrays.stream(input.split(CAR_NAMES_DELIMITER))
                .peek(RacingInputView::assertCarNameNotEmptyString)
                .peek(RacingInputView::assertCarNameLengthUnderFive)
                .collect(Collectors.toList());
    }

    private static void assertCarNameNotEmptyString(String carName) {
        if (carName == null || carName.equals(EMPTY_STRING)) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    private static void assertCarNameLengthUnderFive(String carName) {
        if (CAR_NAME_MAX_LENGTH < carName.length()) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static int tryCount() {
        printLine(TRY_COUNT_QUESTION);
        return parseAnswerAndValidate();
    }

    private static int parseAnswerAndValidate() {
        final int input = SCANNER.nextInt();

        assertPositive(input);

        return input;
    }

    private static void assertPositive(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("0 이상의 값을 입력해주세요.");
        }
    }

}
