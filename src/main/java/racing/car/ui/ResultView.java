package racing.car.ui;

public class ResultView {

    public static final String LINE = "-";

    public void outputView(int n) {
        StringBuilder sb = new StringBuilder();
        generateRepeatedLine(n, sb);

        System.out.println(sb.toString());
    }

    private static void generateRepeatedLine(int n, StringBuilder sb) {
        for (int i = 0; i < n; i++) {
            sb.append(LINE);
        }
    }
}
