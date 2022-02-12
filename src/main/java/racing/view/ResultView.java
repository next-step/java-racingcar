package racing.view;

import java.util.List;
import racing.domain.CarResult;

public class ResultView {

    public static void printResultAndWinners(List<List<CarResult>> rawRoundResults, List<String> winners) {
        System.out.println("실행 결과");
        for (List<CarResult> carResults : rawRoundResults) {
            System.out.println(formatResult(carResults));
        }

        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    private static StringBuilder formatResult(List<CarResult> carResults) {
        final StringBuilder formattedResult = new StringBuilder();

        for(CarResult vo : carResults) {
            final StringBuilder sb = new StringBuilder();
            for(int i = 0; i < vo.getDistance(); i++) {
                sb.append('-');
            }
            formattedResult.append(vo.getName()).append(" : ").append(sb).append("\n");
        }

        return formattedResult;
    }

}
