package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class RacingResult {

    private List<Car> cars;

    private RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingResult getInstance(List<Car> cars) {
        return new RacingResult(cars);
    }

    public static RacingResult toRacingResult(Participants participants) {
        return RacingResult.getInstance(participants.getParticipants());
    }

    public String getWinner() {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getPosition() - o1.getPosition();
            }
        });
        Car firstWinner = cars.get(0);

        String winners = cars.stream()
            .filter(car -> car.comparePosition(firstWinner))
            .map(Car::getName)
            .collect(Collectors.joining(", "));

        return winners;
    }

    public List<Car> getResult() {
        return this.cars;
    }
}