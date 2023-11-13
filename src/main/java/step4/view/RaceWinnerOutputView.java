package step4.view;

import step4.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceWinnerOutputView {

    private final List<Car> cars;
    private static final String SIGN = "-";

    public RaceWinnerOutputView(List<Car> cars) {
        this.cars = cars;
    }

    public void winner() {
        String winnerNames = this.cars.stream().map(car -> car.getName().toString()).collect(Collectors.joining(","));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void progressInGame() {
        cars.forEach(car -> System.out.println(car.getName().toString() + " : " + SIGN.repeat(car.getPosition().getCurrentStatus())));
    }
}
