package racingcar;

import java.io.PrintWriter;
import java.util.List;


public class ResultView {
    private static final String MESSAGE = "실행 결과";
    private final PrintWriter writer;

    public ResultView() {
        this.writer = new PrintWriter(System.out, true);
    }

    public void printGameResult(GameResults results) {
        List<List<Car>> steps = results.getSteps();

        writer.println(MESSAGE);

        for (List<Car> step : steps) {
            printAllCars(step);
        }
    }

    private void printAllCars(List<Car> cars) {
        for (Car car : cars) {
            this.printCar(car);
        }
        writer.println("");
    }

    private void printCar(Car car) {
        int position = car. getPosition();

        for (int i = 0; i < position; ++ i) {
            writer.print('-');
        }
        writer.println("");
    }
}
