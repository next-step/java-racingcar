package study.racing.winners;

import study.racing.car.Car;
import study.racing.car.Position;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public static List<Car> pickWinners(List<Car> cars) {
        Position maxPosition = cars.stream()
                .map(Car::getCurrentPosition)
                .max(Comparator.comparingInt(Position::getValue))
                .orElseThrow(() -> new RuntimeException("우승자를 찾을 수 없습니다."));

        List<Car> winners = cars.stream()
                .filter(car -> car.getCurrentPosition().equals(maxPosition))
                .collect(Collectors.toList());

        return winners;
    }

}