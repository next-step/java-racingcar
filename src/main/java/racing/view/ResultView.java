package racing.view;

public class ResultView {
    private static final String PROGRESS_MARK = "-";

    public static void getProgress(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(PROGRESS_MARK);
        }
        System.out.println(sb);
    }
}
