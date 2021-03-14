package RacingCar.view;

import RacingCar.domain.Car;
import RacingCar.domain.Cars;

public class ResultView {
    private final static String LOCATION_EXPRESSION = "-";
    private final static String SET_OUTPUT_RESULT = "실행 결과\n";

    public static void printStart() {
        System.out.println(SET_OUTPUT_RESULT);
    }

    public static void printLocationView(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(getLocationView(car));
        }
        System.out.println();
    }

    private static String getLocationView(Car car) {
        String result = "";
        for (int i = 0; i < car.getCurrentLocation(); i++) {
            result = result.concat(LOCATION_EXPRESSION);
        }
        return result;
    }
}
