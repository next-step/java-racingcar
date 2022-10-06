package racinggame;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DISTANCE_SYMBOL = "-";

    private OutputView() {}

    public static void printResult(RacingGameResult result) {
        System.out.println("실행 결과");
        result.getRounds().forEach(OutputView::printRoundResult);
        printWinnerNames(result.getWinnerNames());
    }

    private static void printRoundResult(RacingGameRoundResult round) {
        round.getCars().forEach(OutputView::printCarResult);
        System.out.println();
    }

    private static void printCarResult(RacingGameCarResult car) {
        System.out.printf("%s : %s" + StringConstants.NEW_LINE, car.getName(), DISTANCE_SYMBOL.repeat(car.getPosition()));
    }

    private static void printWinnerNames(List<CarName> winners) {
        System.out.printf("%s가 최종 우승했습니다.",
                winners.stream()
                        .map(CarName::toString)
                        .collect(Collectors.joining(StringConstants.COMMA + StringConstants.SPACE))
        );
    }

}
