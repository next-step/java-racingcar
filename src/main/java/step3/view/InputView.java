package step3.view;

import step2.PositiveInteger;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NUM_ASKING = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_NUM_ASKING = "시도할 회수는 몇 회 인가요?";

    private InputView() {

    }

    public static void printCarNumTakingView() {
        System.out.println(CAR_NUM_ASKING);
    }

    public static void printTryNumView() {
        System.out.println(TRY_NUM_ASKING);
    }

    public static PositiveInteger scanNextPositiveInteger() {
        return new PositiveInteger((new Scanner(System.in)).nextInt());
    }

}
