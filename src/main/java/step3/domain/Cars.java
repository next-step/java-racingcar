package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private int numOfMoveTries;

    public Cars(String joinedCarNames) {
        this(Arrays.asList(joinedCarNames.split(",").clone()));
    }

    public Cars(List<String> carNames){
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.numOfMoveTries = 0;
    }

    public void tryMoving(MoveCondition moveCondition) {
        this.cars.forEach(it -> it.moveIf(moveCondition));
        this.numOfMoveTries++;
    }

    public List<Car> findRaceWinner(RaceWinnerFinder raceWinnerFinder) {
        return raceWinnerFinder.find(this.cars);
    }

    public List<CarState> getCarStates() {
        return this.cars.stream()
                .map(CarState::of)
                .collect(Collectors.toList());
    }

    public boolean isRemainingTry(int totalTries) {
        return this.numOfMoveTries < totalTries;
    }
}
