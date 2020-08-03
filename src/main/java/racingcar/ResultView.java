package racingcar;

import java.io.PrintWriter;
import java.util.List;

public class ResultView {
    private final PrintWriter writer;

    public ResultView() {
        this.writer = new PrintWriter(System.out, true);

        writer.println("실행 결과");
    }

    public void printAllCars(List<Car> cars) {
        for (Car car : cars) {
            this.printCar(car);
        }
        writer.println("");
    }

    public void printCar(Car car) {
        int position = car. getPosition();

        for (int i = 0; i < position; ++ i) {
            writer.print('-');
        }
        writer.println("");
    }
}
