package step5.view;

import step5.domain.CarStatus;
import step5.dto.Result;
import step5.dto.RoundResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public static void printGameResult(Result result) {
        System.out.println("\n실행 결과");
        List<RoundResult> roundResults = result.getResults();
        roundResults.forEach(ResultView::printGameRound);
        printWinners(result.getWinners());
    }

    public static void printGameRound(RoundResult roundResult) {
        System.out.println();
        List<CarStatus> carStatuses = roundResult.getCarStatuses();
        carStatuses.forEach(ResultView::printCarStatus);
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
