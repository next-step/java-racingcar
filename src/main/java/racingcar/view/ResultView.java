package racingcar.view;

public class ResultView {

    private static final String RESULT = "실행 결과";
    private static final String HYPHEN = "-";
    private static final String INFIX = " : ";

    public static void printInitialState() {
        System.out.println(RESULT);
    }

    public static void print(String prefix, int count) {
        System.out.print(prefix);
        System.out.print(INFIX);
        printHyphens(count);
    }

    private static void printHyphens(int count) {
        System.out.println(HYPHEN.repeat(count));
    }

    public static void printNewLine() {
        System.out.println();
    }
}
