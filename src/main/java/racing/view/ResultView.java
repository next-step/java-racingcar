package racing.view;

import java.util.List;
import racing.domain.CarResult;

public class ResultView {

    public static void printResultAndWinners(List<List<CarResult>> racingResult,
        List<String> winners) {
        System.out.println("실행 결과");
        for (List<CarResult> roundResult : racingResult) {
            System.out.println(format(roundResult));
        }

        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    private static StringBuilder format(List<CarResult> roundResult) {
        final StringBuilder formattedResult = new StringBuilder();

        for (CarResult carResult : roundResult) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < carResult.getDistance(); i++) {
                sb.append('-');
            }
            formattedResult.append(carResult.getName()).append(" : ").append(sb).append("\n");
        }

        return formattedResult;
    }

}
