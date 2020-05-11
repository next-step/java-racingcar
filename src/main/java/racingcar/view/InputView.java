package racingcar.view;

import java.util.Scanner;

public class InputView {

    private InputView(){
        throw new AssertionError();
    }
    private static final Scanner scanner = new Scanner(System.in);

    private static String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static String GAME_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static int getCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static int getGameRound(){
        System.out.println(GAME_ROUND_MESSAGE);
        return scanner.nextInt();
    }
}