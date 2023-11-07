package racingcar.view;

public class ResultView {
    private static final StringBuilder stringBuilder = new StringBuilder();

    private ResultView() {
    }

    public static void printPosition(int position) {
        stringBuilder.setLength(0);
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }
}
