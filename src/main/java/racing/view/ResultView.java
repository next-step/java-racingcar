package racing.view;

import java.util.List;
import racing.domain.Car;
import racing.domain.Round;
import racing.domain.RoundResult;

public class ResultView {

    public static void printResult(List<RoundResult> results) {
        System.out.println("실행 결과");
        for (RoundResult result : results) {
            System.out.println(formatResult(result.getCars()));
        }
    }

    public static void printWinners(List<String> judgeWinner) {
        System.out.println("최종 우승자: " + String.join(", ", judgeWinner));
    }

    private static StringBuilder formatResult(List<Car> cars) {
        final StringBuilder formattedResult = new StringBuilder();

        for(Car car : cars) {
            final StringBuilder sb = new StringBuilder();
            for(int i = 0; i < car.getDistance(); i++) {
                sb.append('-');
            }
            formattedResult.append(car.getName() + " : " + sb + "\n");
        }

        return formattedResult;
    }
}
