package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_DESCRIPTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PLAY_DESCRIPTION = "시도할 횟수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getCarNames() {
        System.out.println(CAR_DESCRIPTION);
        return parseNames(getNameStr());
    }

    public int getPlayCount() {
        System.out.println(PLAY_DESCRIPTION);
        return getZeroOrPositiveInteger();
    }

    private List<String> parseNames(String nameStr) {
        String[] names = nameStr.split(",");
        return Arrays.asList(names);
    }

    private String getNameStr() {
        String nameStr = scanner.nextLine();
        if (nameStr.isEmpty()) {
            throw new RuntimeException("자동차 이름을 입력해주세요.");
        }

        return nameStr;
    }

    private int getZeroOrPositiveInteger() {
        int intValue = scanner.nextInt();
        if (intValue < 0) {
            throw new RuntimeException("0 이상의 숫자를 입력해주세요.");
        }

        return intValue;
    }
}
