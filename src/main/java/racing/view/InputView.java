package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static String GET_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String GET_GAME_CNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static String getCarNames() {
        System.out.println(GET_CARS_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static int getTryCnt() {
        int result;

        try {
            System.out.println(GET_GAME_CNT_MESSAGE);
            result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            result = Integer.MIN_VALUE;
        }

        return result;
    }
}