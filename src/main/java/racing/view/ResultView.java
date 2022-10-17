package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

public class ResultView {

    private static final String SEPARATOR = " : ";
    private static final String MOVE_PATTERN = "-";

    public void printRacingResult(Cars cars) {
        for (Car car: cars.getCarList()) {
            System.out.println(printCarPosition(car));
        }
        System.out.println();
    }

    public static String printCarPosition(Car car) {
        StringBuffer sb = new StringBuffer();
        sb.append(car.getName());
        sb.append(SEPARATOR);
        sb.append(positionStatus(car.getPosition()));
        return sb.toString();
    }

    public static String positionStatus(int position) {
        StringBuffer sb = new StringBuffer();
        sb.append(MOVE_PATTERN.repeat(position));
        return sb.toString();
    }
}
