package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.*;
import java.util.stream.Collectors;

public class Round {
    private final Cars cars;

    public Round(Cars cars) {
        this.cars = cars;
    }

    public Cars getAllCars() {
        return cars;
    }

    public static Map<String, Integer> roundResult(Round round) {
        Map<String, Integer> result = new HashMap<>();
        List<Car> cars = round.getAllCars().getCarsAtRound();
        for (Car car : cars) {
            result.put(car.getName(), car.getPosition());
        }
        return result;
    }

    public static List<String> winners(Map<String, Integer> finalRound) {
        int maxPosition = finalRound.values().stream().max(Integer::compare).orElseThrow(NoSuchElementException::new);
        return finalRound.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return Objects.equals(cars, round.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
