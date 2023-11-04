package racinggame.view;

import static java.lang.System.out;

import racinggame.domain.Car;
import racinggame.domain.Cars;

public class ResultView {

    public static final String COLON = " : ";
    private static final String RESULT_SIGN = "실행 결과";
    private static final String DASH = "-";

    private ResultView() {
    }

    public static void br() {
        out.println();
    }

    public static void resultSign() {
        out.println(RESULT_SIGN);
    }

    public static void report(Cars cars) {
        for (Car car : cars.getAll()) {
            out.println(createResult(car));
        }
        br();
    }

    private static String createResult(Car car) {
        return car.name() + COLON + DASH.repeat(Math.max(0, car.movingDistance().distance()));
    }

}
