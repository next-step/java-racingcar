package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {
    private final static String LOCATION_EXPRESSION = "-";
    private final static String SET_OUTPUT_RESULT = "실행 결과\n";

    public void printStart() {
        System.out.println(SET_OUTPUT_RESULT);
    }

    public void printLocationView(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getLocationView(car));
        }
    }

    public String getLocationView(Car car) {
        String result = "";
        for (Integer i = 0; i < car.getCurrentLocation(); i++) {
            result = result.concat(LOCATION_EXPRESSION);
        }
        return result;
    }
}
