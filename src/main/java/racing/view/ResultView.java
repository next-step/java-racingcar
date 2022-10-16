package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

public class ResultView {
    private static final String MOVE_PATTERN = "-";

    public void printRacingResult(Cars cars) {
        for (Car car: cars.getCarList()) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public void printCarPosition(Car car) {
        System.out.println(positionStatus(car.getPosition()));
    }

    public static String positionStatus(int position) {
        StringBuffer sb = new StringBuffer();
        sb.append(MOVE_PATTERN.repeat(position));
        return sb.toString();
    }
}
