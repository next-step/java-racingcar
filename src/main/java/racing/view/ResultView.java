package racing.view;

import java.util.List;
import racing.domain.CarResult;
import racing.domain.RoundResult;

public class ResultView {

    public static void printResult(List<RoundResult> results) {
        System.out.println("실행 결과");
        for (RoundResult result : results) {
            System.out.println(formatResult(result.getResultVOS()));
        }
    }

    public static void printWinners(List<String> judgeWinner) {
        System.out.println("최종 우승자: " + String.join(", ", judgeWinner));
    }

    private static StringBuilder formatResult(List<CarResult> carResultVOS) {
        final StringBuilder formattedResult = new StringBuilder();

        for(CarResult vo : carResultVOS) {
            final StringBuilder sb = new StringBuilder();
            for(int i = 0; i < vo.getDistance(); i++) {
                sb.append('-');
            }
            formattedResult.append(vo.getName()).append(" : ").append(sb).append("\n");
        }

        return formattedResult;
    }
}
