package step4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printGameResult(int round, boolean isFinalRound, RacingGameResult racingGameResult) {
        printRoundMessage(round);
        List<CarStatus> carStatuses = racingGameResult.getCarStatuses();
        carStatuses.forEach(ResultView::printCarStatus);
        if (isFinalRound) {
            printWinners(racingGameResult.getWinners());
        }
    }

    private static void printRoundMessage(int round) {
        System.out.println();
        if (round == 0) System.out.println("실행 결과");
    }

    private static void printCarStatus(CarStatus carStatus) {
        String position = IntStream.range(0, carStatus.getPosition())
                .mapToObj(x -> "-")
                .collect(Collectors.joining());
        System.out.println(carStatus.getName() + " : " + position);
    }

    private static void printWinners(List<String> winners) {
        String names = String.join(", ", winners);
        System.out.println(names + " 이(가) 최종 우승했습니다.");
    }


    public static void printError(String errorMessage) {
        System.out.println("## Error 발생 ##");
        System.out.println("## " + errorMessage + " ##");
    }
}
