package racing.view;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Position;

import java.util.List;

public class ResultView {

    private static final String SEPARATOR = " : ";
    private static final String MOVE_PATTERN = "-";

    public void printRacingResult(Cars cars) {
        printRacingResult(cars.getCarList());
    }

    public void printRacingResult(List<Car> carList) {
        for (Car car: carList) {
            System.out.println(printCarPosition(car));
        }
        System.out.println();
    }

    public String printCarPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(SEPARATOR);
        sb.append(positionStatus(car.getPosition()));
        return sb.toString();
    }

    public String positionStatus(Position position) {
        StringBuilder sb = new StringBuilder();
        sb.append(MOVE_PATTERN.repeat(position.getPosition()));
        return sb.toString();
    }
}
