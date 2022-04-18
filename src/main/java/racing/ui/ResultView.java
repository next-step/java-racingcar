package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class ResultView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String DISPLAY_MARK = "-";
    private static final String WINNER_JOIN_DELIMITER = ",";
    private static final String DISPLAY_COLON = " : ";
    private static final String WINNER_PRINT_FORMAT = "%s 가 최종 우승했습니다.%n";
    private static final int BUILDER_LENGTH = 0;
    private static ResultView instance;
    private final StringBuilder stringBuilder = new StringBuilder();

    public static ResultView getInstance() {
        if (instance == null) {
            instance = new ResultView();
        }
        return instance;
    }

    private void printMark(Car car) {
        assert car != null;
        stringBuilder.setLength(BUILDER_LENGTH);
        stringBuilder.append(car.getName());
        stringBuilder.append(DISPLAY_COLON);
        IntStream.range(0, car.getPosition().getCurrentPosition())
                .mapToObj(i -> DISPLAY_MARK)
                .forEach(stringBuilder::append);
        System.out.println(stringBuilder);
    }

    public void printRound(Cars cars) {
        Objects.requireNonNull(cars);
        cars.getCars().forEach(this::printMark);
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        if (winner == null || winner.isEmpty()) {
            return;
        }

        String joinWinners = String.join(WINNER_JOIN_DELIMITER, winner);
        System.out.printf(WINNER_PRINT_FORMAT, joinWinners);
    }

    public void startPrint() {
        System.out.println();
        System.out.println(PRINT_RESULT_MESSAGE);
    }
}
