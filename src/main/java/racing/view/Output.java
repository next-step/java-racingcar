package racing.view;

import racing.domain.Car;
import racing.domain.Game;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    final static String DASH = "-";

    public static void showSessionStatus(Game game) {
        for (Car car : game.getAttendedCars()) {
            showDistance(car);
        }
        System.out.println();
    }

    public static void showDistance(Car car) {
        String distanceIndicator = DASH.repeat(car.getCurrentLocation());

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(car.getName()).append(": ").append(distanceIndicator));
    }

    public static void showWinner(List<Car> winners) {
        if (winners.isEmpty()) {
            throw new IllegalArgumentException("1명 이상의 우승자가 있어야 합니다.");
        }

        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
