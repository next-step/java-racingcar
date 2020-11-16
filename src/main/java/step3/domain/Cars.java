package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String joinedCarNames) {
        List<String> carNames = Arrays.asList(joinedCarNames.split(",").clone());
        this.cars = new ArrayList<>(carNames.size());
        carNames.forEach(it -> this.cars.add(new Car(it)));
    }

    public void tryMoving(MoveCondition moveCondition) {
        this.cars.forEach(it -> it.moveIf(moveCondition));
    }

    public List<Car> findRaceWinner(RaceWinnerFinder raceWinnerFinder) {
        return raceWinnerFinder.find(this.cars);
    }

    public List<CarState> getCarStates() {
        return this.cars.stream().map(it -> CarState.of(it)).collect(Collectors.toList());
    }
}
