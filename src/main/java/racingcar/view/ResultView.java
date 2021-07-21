package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String MOVE_SYMBOL = "-";
    private static final String JOIN_SYMBOL = ", ";
    private static final String WINNER_NOTICE_STATEMENT_FORMAT = "%s 가 최종 우승했습니다.";
    private static final String CAR_MOVEMENT_FORMAT = "%s : %s";
    private static final String EXECUTION_RESULT = "실행 결과";

    private ResultView() {}

    public static void printResultStatement() {
        printStatement(EXECUTION_RESULT);
    }

    public static void printState(List<CarDto> carDtos) {
        carDtos.forEach(ResultView::printCarMovement);

        printNewLine();
    }

    public static void printWinners(List<String> winners) {
        String joinedWinnerString = winners.stream()
                .collect(Collectors.joining(JOIN_SYMBOL));

        printStatement(String.format(WINNER_NOTICE_STATEMENT_FORMAT, joinedWinnerString));
    }

    private static void printCarMovement(CarDto carDto) {
        String name = carDto.getName();
        String movement = IntStream.rangeClosed(0, carDto.getPosition())
                .mapToObj(x -> MOVE_SYMBOL)
                .collect(Collectors.joining());

        printStatement(String.format(CAR_MOVEMENT_FORMAT, name, movement));
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }
}
