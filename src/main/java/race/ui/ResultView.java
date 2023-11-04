package race.ui;

public class ResultView {
    private final static String STEP_STRING = "-";

    public static void print(final int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(STEP_STRING);
        }

        System.out.println(stringBuilder);
    }

    public static void println() {
        System.out.println();
    }
}
