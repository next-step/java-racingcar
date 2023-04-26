package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(String[] carNames) {
        List<RacingCar> originCars = new ArrayList<>();

        for(String carName : carNames) {
            originCars.add(new RacingCar(carName));
        }

        this.racingCars = new ArrayList<>(originCars);
    }

    public RacingCars(List<RacingCar> carList) {
        this.racingCars = new ArrayList<>(carList);
    }

    public void runRacingRound(MoveStrategy moveStrategy) {

        for (RacingCar racingCar : this.racingCars) {
            racingCar.tryToMove(moveStrategy);
        }
    }

    public int findMaxPosition() {

        return this.racingCars.stream()
                .map(racingCar -> racingCar.position())
                .max(Integer::compare)  // Optional<Integer>
                .get();
    }

    public List<String> makeWinnerList() {
        int maxPosition = findMaxPosition();

        List<String> gameWinner = this.racingCars.stream()
                .filter(racingCar -> racingCar.position() == maxPosition)
                .map(racingCar -> racingCar.name())
                .collect(Collectors.toList());

        return gameWinner;
    }

    public List<RacingCar> statusOfRacingCars() {
        return new ArrayList<>(racingCars);
    }
}
