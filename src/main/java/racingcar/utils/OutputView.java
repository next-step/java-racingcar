package racingcar.utils;

public class OutputView {

    public static final char MOVE_STRING = '-';

    public static void outputText(String text) {
        System.out.println(text);
    }

    public static void outputMove(int value) {
        for (int i = 0; i < value; i++) {
            System.out.print(MOVE_STRING);
        }
        System.out.println();
    }
}
