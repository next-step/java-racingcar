package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public static final String POSITION_VIEW = "-";

    public static void endMessage() {
        System.out.println("실행 결과");
    }

    public static void gameResult(Cars cars) {
        for (Car car : cars.cars()) {
            System.out.println(viewResult(car));
        }
        System.out.println();
    }

    private static String viewResult(Car car) {
        return car.name() + " : "+ viewPosition(car.positionNumber());
    }

    private static String viewPosition(int position) {
        return POSITION_VIEW.repeat(Math.max(0, position));
    }
}
