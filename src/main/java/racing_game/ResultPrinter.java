package racing_game;

import java.io.PrintStream;
import java.util.List;

public class ResultPrinter implements AutoCloseable {

    private final PrintStream printStream;

    public ResultPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printCurrentState(List<Car> cars) {
        for (Car car : cars) {
            printStream.println(car.getCurrentState());
        }
    }

    public void printGameResult(List<String> winnerNames) {
        printStream.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    @Override
    public void close() {
        this.printStream.close();
    }
}
