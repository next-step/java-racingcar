package racingcar.view;

import racingcar.dto.CarResultDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

import java.util.List;

public class ResultView {
    private static final String RESULT_DELIMITER = "-";

    private static final String NAME_DELIMITER = " : ";

    private static final String WINNER_DELIMITER = ", ";

    public static void printGameResult(GameResultDto gameResult) {
        printResultComment();
        gameResult.getRoundResults().forEach(ResultView::printRoundResult);
    }

    public static void printWinners(List<String> winners) {
        String winnersString = String.join(WINNER_DELIMITER, winners);
        System.out.println(winnersString + "가 최종 우승했습니다.");
    }

    private static void printRoundResult(RoundResultDto roundResult) {
        roundResult.getResults().forEach(ResultView::printCarResult);
        System.out.println();
    }

    private static void printCarResult(CarResultDto carResult) {
        printDelimitedResult(carResult.position, carResult.name);
        System.out.println();
    }

    private static void printDelimitedResult(Integer position, String name) {
        System.out.print(name);
        System.out.print(NAME_DELIMITER);
        for (int i = 0; i < position; i++) {
            System.out.print(RESULT_DELIMITER);
        }
    }

    private static void printResultComment() {
        System.out.println("실행 결과");
    }
}
