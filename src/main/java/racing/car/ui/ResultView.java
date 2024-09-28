package racing.car.ui;

public class ResultView {

    public static final String LINE = "-";

    public void outputView(int n) {
        StringBuilder sb = new StringBuilder();
        makeSentence(n, sb);

        System.out.println(sb.toString());
    }

    private static void makeSentence(int n, StringBuilder sb) {
        for (int i = 0; i < n; i++) {
            sb.append(LINE);
        }
    }
}
