package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinedCars {

    private List<Car> cars;

    public JoinedCars(String joinedCarNames) {
        List<String> carNames = Arrays.asList(joinedCarNames.split(",").clone());
        cars = new ArrayList<>(carNames.size());
        carNames.forEach(it -> cars.add(new Car(it)));
    }

    public void tryMoving(RaceRoulette raceRoulette) {
        cars.forEach(it -> it.moveIf(() -> raceRoulette.spin() >= 4));
    }

    public List<Car> findRaceWinner(RaceWinnerFinder raceWinnerFinder) {
        return raceWinnerFinder.find(cars);
    }

    public List<CarState> getCarStates() {
        return cars.stream().map(it -> CarState.of(it)).collect(Collectors.toList());
    }
}
