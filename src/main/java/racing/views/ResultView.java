package racing.views;

import racing.domain.Car;
import racing.domain.Round;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    public static final String DISTANCE_MARK = "-";

    public static void show(Round round) {
        for (Car car : round.getCarList()) {
            showCar(car);
        }
    }

    private static void showCar(Car car) {
        final String carName = String.format("%-" + Car.MAX_NAME_LENGTH + "s", car.getName());
        final String carDistance = Stream.generate(() -> DISTANCE_MARK)
                .limit(car.getDistance())
                .reduce("", (a, b) -> a + b);
        System.out.println(carName + " : " + carDistance);
    }

    public static void show(List<Car> winnerList) {
        final String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
