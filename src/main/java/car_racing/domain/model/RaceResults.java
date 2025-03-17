package car_racing.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResults {
    private static final String RACE_RESULT_DELIMITER = " : ";

    private final List<Car> cars;

    public RaceResults(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getRaceResultOfNthRound(int n) {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(getRaceResultOfNthRoundOfEachCar(n, car));
        }
        return result;
    }

    private String getRaceResultOfNthRoundOfEachCar(int n, Car car) {
        RaceResult raceResult = car.getRaceResult();

        StringBuilder sb = new StringBuilder();
        sb.append(car.getName())
                .append(RACE_RESULT_DELIMITER)
                .append(raceResult.getPositionOfNthRound(n));

        return sb.toString();
    }

    public List<Car> getWinners() {
        if (cars.isEmpty()) return Collections.emptyList();

        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

}
