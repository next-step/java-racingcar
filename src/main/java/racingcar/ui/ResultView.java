package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

    private final static String CAR_POSITION_STRING = "-";

    private ResultView() {

    }

    public static void printExecuteResultString() {
        System.out.println("실행 결과");
    }

    public static void print(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.get()) {
            String carPosition = CAR_POSITION_STRING.repeat(car.getDistance().get());
            stringBuilder.append(carPosition).append("\n");
        }

        System.out.println(stringBuilder);
    }

}
