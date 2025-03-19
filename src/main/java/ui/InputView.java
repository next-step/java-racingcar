package ui;

import racing.GrandPrix;
import racing.ZeroToTenDice;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String PARTICIPANTS_CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PLAY_TIME_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static GrandPrix makeGrandPrix() {
        System.out.println(PARTICIPANTS_CAR_NAMES_INPUT_MESSAGE);
        var carNames = Arrays.asList(scanner.nextLine().split(","));
        System.out.println(PLAY_TIME_COUNT_INPUT_MESSAGE);
        var playTimeCount = scanner.nextInt();

        return new GrandPrix(playTimeCount, carNames);
    }
}
