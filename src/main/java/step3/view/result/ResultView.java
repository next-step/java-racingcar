package step3.view.result;

import step3.car.Car;
import step3.car.Position;

import java.util.List;

public class ResultView {

    private static final String MARKER = "-";

    public void printTitle() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<Car> cars) {
        cars.forEach(this::printCarMovedDistance);
        System.out.println();
    }

    private void printCarMovedDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        Position currentPosition = car.getCurrentPosition();
        int value = currentPosition.getValue();

        for (int i = 0; i < value; i++) {
            sb.append(MARKER);
        }
        System.out.println(sb.toString());
    }
}
