package carracing.view;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.Position;
import carracing.util.StringUtils;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_EXPRESSION = "-";
    private static final String CAR_POSITION_PRINT_FORMAT = "%-5s\t: %s";
    private static final String WINNER_PRINT_FORMAT = "최종 우승자는 %s입니다.";
    private static final String WINNER_PRINT_DELIMITER = ", ";

    private final PrintStream printStream;

    private OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static OutputView of(PrintStream printStream) {
        return new OutputView(printStream);
    }

    public void printCarNameInputMessage() {
        printStream.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printInputMoveCountMessage() {
        printStream.println(MOVE_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        printStream.println(RESULT_MESSAGE);
    }

    public void printNewLine() {
        printStream.println();
    }

    public void printPositions(Cars cars) {
        cars.forEach(this::printPosition);
    }

    public void printPosition(Car car) {
        printStream.println(String.format(CAR_POSITION_PRINT_FORMAT, car.getCarName(), render(car.getPosition())));
    }

    private String render(Position position) {
        return StringUtils.repeat(POSITION_EXPRESSION, position.getValue());
    }

    public void printWinners(List<Car> winners) {
        printStream.println(String.format(WINNER_PRINT_FORMAT, joinNames(winners)));
    }

    private String joinNames(List<Car> winners) {
        return winners.stream()
                .map(car -> car.getCarName().toString())
                .collect(Collectors.joining(WINNER_PRINT_DELIMITER));
    }
}
