package racing.views;

import racing.domain.Car;
import racing.domain.Round;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void show(Round round) {
        for (Car car : round.getCarList()) {
            showCar(car);
        }
    }

    private static void showCar(Car car) {
        System.out.print(String.format("%-" + Car.MAX_NAME_LENGTH + "s", car.getName()) + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void show(List<Car> winnerList) {
        final String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
