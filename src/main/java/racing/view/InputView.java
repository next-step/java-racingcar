package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static String GET_CAR_CNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static String GET_GAME_CNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static int getCarCnt() {
        int result;

        try {
            System.out.println(GET_CAR_CNT_MESSAGE);
            result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            result = Integer.MIN_VALUE;
        }

        return result;
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