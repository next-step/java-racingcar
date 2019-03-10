package racingcar;

import java.util.stream.Collectors;

public class ResultView {

    public static void print(GameResult result) {
        System.out.println("실행 결과\n");

        for (int i = 0; i < result.countRoundLength(); i++) {
            Round round = result.getRound(i);
            System.out.println(displayTraces(round) + "\n");
        }
    }

    private static String displayTraces(Round round) {
        return round.positions.stream()
                .map(it -> displayTrace(it))
                .collect(Collectors.joining("\n"));
    }

    private static String displayTrace(int position) {
        String trace = "";
        for (int i = 0; i < position; i++) {
            trace += "-";
        }
        return trace;
    }
}
