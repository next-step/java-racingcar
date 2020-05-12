package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String SEPARATOR = ",";
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        throw new AssertionError();
    }

    public static String[] getCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
        String line = scanner.nextLine();
        return Arrays.stream(line.split(SEPARATOR)).map(String::trim).toArray(String[]::new);
    }

    public static int getGameRound() {
        System.out.println(GAME_ROUND_MESSAGE);
        return scanner.nextInt();
    }
}