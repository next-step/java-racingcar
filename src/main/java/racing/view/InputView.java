package racing.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String CAR_COUNT_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final String ROUND_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";

    public InputView() {
        throw new UnsupportedOperationException("유틸형 클래스는 생성할 수 없습니다");
    }

    public static List<String> readCarNames() {
        System.out.println(CAR_COUNT_QUESTION);
        return getNames(SCANNER.nextLine());
    }

    private static List<String> getNames(String input) {
        return List.of(input.split(","));
    }

    public static int readRoundCount() {
        System.out.println(ROUND_COUNT_QUESTION);
        return SCANNER.nextInt();
    }
}
