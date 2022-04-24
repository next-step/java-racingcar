package study.step4.view;

import study.step4.domain.Cars;
import study.step4.util.StringParser;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COMMA = ",";
    private static final String GAME_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public String[] carSetting() {
        System.out.println(CAR_NAME_INPUT);
        String input = scanner.next();
        return carNameParser(input);
    }

    private String[] carNameParser(String input) {
        return StringParser.impl(input, COMMA);
    }

    public int gameCountSetting() {
        System.out.println(GAME_TRY_COUNT);
        return scanner.nextInt();
    }
}
