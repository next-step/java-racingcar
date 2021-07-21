package racingcar.view;

import java.util.List;
import racingcar.Car;

public class ResultView {

    private final char distanceFlag = '-';

    public void pirntDistance(List<Car> cars) {
        cars.forEach(car -> System.out.println(getPirntDistance(car)));
    }

    private String getPirntDistance(Car car) {
        StringBuilder printDistance = new StringBuilder();

        for (int i = 0; i < car.getDistance(); i++) {
            printDistance.append(distanceFlag);
        }

        return printDistance.toString();
    }
}
