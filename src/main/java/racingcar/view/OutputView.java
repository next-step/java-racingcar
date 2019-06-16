package racingcar.view;

public class OutputView {
    private static final String CAR_MARK = "-";

    public static void printCarPosition(int position) {
        for (int i = 0; i <= position; i++) {
            System.out.print(CAR_MARK);
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundSeparator() {
        System.out.println();
    }
}
