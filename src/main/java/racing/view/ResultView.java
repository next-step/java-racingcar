package racing.view;

import java.util.List;
import racing.domain.CarResult;

public class ResultView {

    public static void printResultAndWinners(List<List<CarResult>> totalRoundResults, List<String> winners) {
        System.out.println("실행 결과");
        for (List<CarResult> roundResult : totalRoundResults) {
            System.out.println(formatResult(roundResult));
        }

        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    private static StringBuilder formatResult(List<CarResult> roundResult) {
        final StringBuilder formattedResult = new StringBuilder();

        for(CarResult carResult : roundResult) {
            final StringBuilder sb = new StringBuilder();
            for(int i = 0; i < carResult.getDistance(); i++) {
                sb.append('-');
            }
            formattedResult.append(carResult.getName()).append(" : ").append(sb).append("\n");
        }

        return formattedResult;
    }

}
