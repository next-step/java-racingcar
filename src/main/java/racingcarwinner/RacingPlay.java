package racingcarwinner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcarwinner.Car.createDefaultCar;

public class RacingPlay {

    private RandomNumber randomNumber;

    public RacingPlay() {
        this.randomNumber = new RandomNumberImpl();
    }

    public List<Car> readyForRacing(String[] carNames) {
        return Arrays.stream(carNames).map(carName -> createDefaultCar(carName)).collect(Collectors.toList());
    }

    public void playRacingCar(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return randomNumber.getRandomNumber(10);
    }

    public String findWinner(List<Car> racingOutput) {
        int maxLocation = findMaxLocation(racingOutput);
        return racingOutput.stream()
                .filter(car -> car.isMaxLocation(maxLocation))
                .map(Car::getName).collect(Collectors.joining(", "));
    }

    private int findMaxLocation(List<Car> racingOutput) {
        return racingOutput.stream().mapToInt(Car::getLocation).max().orElse(1);
    }
}
