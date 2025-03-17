package racingcar;

import java.util.List;

public class ResultView {

    public static String printCarsDistance(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        cars.stream().forEachOrdered(car -> {
            for (int i = 0; i < car.getDistance(); i++) {
                result.append("-");
            }
            result.append("\n");
        });
        return result.toString();
    }
}
