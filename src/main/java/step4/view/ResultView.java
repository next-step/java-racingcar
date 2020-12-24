package step4.view;

import step4.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public void carPositionPrints(List<Car> car) {
        car.forEach(this::carPositionPrint);
    }

    private void carPositionPrint(Car car) {
        carNamePrint(car);
        IntStream.range(0,car.carPosition()).forEach(i -> System.out.print("-"));
        writeNewLine();
    }

    private void carNamePrint(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private void writeNewLine() {
        System.out.println();
    }

    public void winnerNamePrints(String winners) {
        System.out.print(winners + "가 최종 우승했습니다.");
    }
}
