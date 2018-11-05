package racing_game;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPrinter implements AutoCloseable {

    private static final String CAR_SHAPE ="-";

    private final PrintStream printStream;

    public ResultPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printCurrentState(String carName, int moveCount) {
        StringBuilder stringBuilder = new StringBuilder(moveCount);
        stringBuilder.append(carName);
        stringBuilder.append(" : ");
        for (int i = 0; i < moveCount; i++) {
            stringBuilder.append(CAR_SHAPE);
        }
        this.printStream.println(stringBuilder.toString());
    }

    public void printGameResult(List<Car> cars) {
        List<String> winnerNames = findWinnerNames(cars);
        printStream.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    private List<String> findWinnerNames(List<Car> cars) {
        final int maxMoveCount = findMaxMoveCount(cars);

        return cars.stream()
                .filter(car -> isMaxMoveCount(car, maxMoveCount))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private boolean isMaxMoveCount(Car car, int maxMoveCount) {
        return car.getMoveCount() == maxMoveCount;
    }

    private int findMaxMoveCount(List<Car> cars) {
        int maxMoveCount = 0;

        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        return maxMoveCount;
    }

    @Override
    public void close() {
        this.printStream.close();
    }
}
