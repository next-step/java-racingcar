package study.racingcar;

import java.util.Scanner;

public class InputView {

    private static String NUMBER_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static String NUMBER_OF_GAME_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static int setCars() {
        System.out.println(NUMBER_OF_CAR_MESSAGE);

        return inputNumber();
    }

    public static int setGames() {
        System.out.println(NUMBER_OF_GAME_MESSAGE);

        return inputNumber();
    }

    private static int inputNumber() {

        return new Scanner(System.in).nextInt();
    }
}
