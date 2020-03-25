package racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static String GET_CAR_CNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static String GET_GAME_CNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static String INTEGER_INPUT_MISMATCH_EXCEPTION_MESSAGE = "숫자 값을 입력 해 주세요!";

    public static int getCarCnt() {
        try {
            System.out.println(GET_CAR_CNT_MESSAGE);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(INTEGER_INPUT_MISMATCH_EXCEPTION_MESSAGE);
            return getCarCnt();
        }
    }

    public static int getTryCnt() {
        try {
            System.out.println(GET_GAME_CNT_MESSAGE);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(INTEGER_INPUT_MISMATCH_EXCEPTION_MESSAGE);
            return getTryCnt();
        }
    }
}
