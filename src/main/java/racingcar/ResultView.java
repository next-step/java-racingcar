package racingcar;

public class ResultView {

    private static final String LINE = "-".repeat(5);

    public static void roundStart(int roundNumber) {
        System.out.println(LINE + roundNumber + " 라운드 시작!" + LINE);
    }

    public static void drawCarPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-".repeat(position));
        System.out.println(stringBuilder.toString());
    }
}
