package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static String printWinners(List<Car> cars) {
        return String.format("%s가 최종 우승했습니다.", cars.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }

    public static String printCarsDistance(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        cars.stream().forEachOrdered(car -> {
            result.append(String.format("%5s : ", car.getName()));
            for (int i = 0; i < car.getDistance(); i++) {
                result.append("-");
            }
            result.append("\n");
        });
        return result.toString();
    }
}
