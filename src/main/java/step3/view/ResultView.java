package step3.view;

import step3.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public void carPositionPrints(List<Car> car) {
        car.forEach(this::carPositionPrint);
    }

    private void carPositionPrint(Car car) {
        IntStream.range(0,car.getPosition()).forEach(i -> System.out.print("-"));
        writeNewLine();
    }

    private void writeNewLine() {
        System.out.println();
    }
}
