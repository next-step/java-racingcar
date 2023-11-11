package racingcarwinner.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcarwinner.domain.Car.createDefaultCar;

public class RacingPlay {

    private MovableStrategy movableStrategy;

    public RacingPlay() {
    }

    public RacingPlay(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public List<Car> readyForRacing(String[] carNames) {
        return Arrays.stream(carNames).map(carName -> createDefaultCar(carName)).collect(Collectors.toList());
    }

    public void playRacingCar(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(movableStrategy);
        }
    }

    public String findWinner(List<Car> racingOutput) {
        int maxLocation = findMaxLocation(racingOutput);
        return racingOutput.stream()
                .filter(car -> car.isMaxLocation(maxLocation))
                .map(Car::name).collect(Collectors.joining(", "));
    }

    private int findMaxLocation(List<Car> racingOutput) {
        return racingOutput.stream().mapToInt(Car::location).max().orElse(1);
    }
}
