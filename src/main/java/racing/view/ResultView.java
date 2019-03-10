package racing.view;


import java.util.List;

public class ResultView {

    private static final char CHAR_TO_CONVERT = '-';

    public static void render(List<String> results) {
    }

    public static String convertToChars(List<Integer> positions) {
        StringBuilder sb = new StringBuilder();
        appendPositions(sb, positions);
        return sb.toString();
    }


    private static void appendPositions(StringBuilder sb, List<Integer> positions) {
        for (int position : positions) {
            appendPosition(sb, position);
        }
    }

    private static void appendPosition(StringBuilder sb, int position) {
        for (int i = 0; i < position; i++) {
            sb.append(CHAR_TO_CONVERT);
        }
        sb.append("\n");
    }
}
