package step3.view.result;

import step3.car.Car;

import java.util.List;

public class ResultView {

    public void printTitle() {
        System.out.println("실행 결과");
    }

    public void printMoveResult(List<Car> cars) {
        cars.forEach(this::printCarMovedDistance);
        System.out.println();
    }

    private void printCarMovedDistance(Car car) {
        System.out.println(car.getMovedDistance());
    }
}
