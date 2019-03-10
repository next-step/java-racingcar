package racing.view;


import racing.board.RacingGameBoard;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final char CHAR_TO_CONVERT = '-';

    public static void render(List<String> results) {
        System.out.println("실행 결과");
        System.out.print(results
                .stream()
                .collect(Collectors.joining("\n")));
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
