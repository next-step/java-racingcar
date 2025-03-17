package ui;

import racing.GrandPrix;

import java.util.Random;
import java.util.Scanner;

public class InputView {
    private static final String PARTICIPANTS_CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String PLAY_TIME_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static GrandPrix makeGrandPrix() {
        System.out.println(PARTICIPANTS_CAR_COUNT_INPUT_MESSAGE);
        var participantsCarCount = scanner.nextInt();
        System.out.println(PLAY_TIME_COUNT_INPUT_MESSAGE);
        var playTimeCount = scanner.nextInt();

        return new GrandPrix(playTimeCount, participantsCarCount);
    }
}
