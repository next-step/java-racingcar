package racingcar.view;

import java.util.List;

public class ResultView {

    public static void printGameStatus(String name, int move) {
        String dashes = getDashByMove(move);
        System.out.println(name + ":" + dashes);
    }

    public static void printGameResult(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    public static void printGameResultMessage() {
        System.out.println("실행 결과");
    }

    private static String getDashByMove(int move) {
        StringBuilder dash = new StringBuilder();

        for (int i = 0; i < move; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
