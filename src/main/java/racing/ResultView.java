package racing;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {
    }

    public static void status(Car car) {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < car.carDistance(); i++) {
            status.append("-");
        }

        System.out.println(car.carName() + ": " + status);
    }

    public static List<String> winner(List<Car> cars) {
        int maxDistance = cars.stream()
                .map(Car::carDistance)
                .mapToInt(x -> x)
                .max().orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(car -> car.carDistance() == maxDistance)
                .map(Car::carName)
                .collect(Collectors.toList());
    }


    public static void raceResult(List<Car> cars) {
        String winners = winner(cars).toString();
        System.out.println(winners.substring(1, winners.length() - 1) + "가 최종 우승하였습니다.");
    }
}
