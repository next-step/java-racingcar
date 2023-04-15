package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printGameResult(int round, RacingGameResult racingGameResult) {
        printRoundMessage(round);
        List<CarStatus> carStatuses = racingGameResult.getCarStatuses();
        carStatuses.forEach(ResultView::printCarStatus);
    }

    private static void printRoundMessage(int round) {
        System.out.println();
        if (round == 0) System.out.println("실행 결과");
    }

    private static void printCarStatus(CarStatus carStatus) {
        String position = IntStream.range(0, carStatus.getPosition())
                .mapToObj(x -> "-")
                .collect(Collectors.joining());
        System.out.println(position);
    }

    public static void printError(String errorMessage) {
        System.out.println("## Error 발생 ##");
        System.out.println("## " + errorMessage + " ##");
    }
}
