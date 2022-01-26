package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.ResultDto;

public class OutputView {

    private static final String DELIMITER = ", ";

    private OutputView() {
    }

    public static void showResult(List<ResultDto> cars) {
        cars.forEach(OutputView::showCarStatus);
        System.out.println();
    }

    private static void showCarStatus(ResultDto resultDto) {
        System.out.println(resultDto.getCurrentStatus());
    }

    public static void showWinners(List<ResultDto> winners) {
        String winnerNames = createWinnerNames(winners);
        System.out.println("최종 우승자: " + winnerNames);
    }

    private static String createWinnerNames(List<ResultDto> winners) {
        return winners.stream()
            .map(ResultDto::name)
            .collect(Collectors.joining(DELIMITER));
    }
}
