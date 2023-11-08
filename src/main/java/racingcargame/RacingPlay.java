package racingcargame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingPlay {

    private RandomNumber randomNumber;

    public RacingPlay() {
        this.randomNumber = new RandomNumberImpl();
    }

    public List<Car> readyForRacing(int carNumber) {
        return Stream.generate(() -> new Car(0)).limit(carNumber).collect(Collectors.toList());
    }

    public void playRacingCar(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            moveForward(getRandomNumber(), carList.get(i));
        }
    }

    private int getRandomNumber() {
        return randomNumber.getRandomNumber(10);
    }

    public void moveForward(int randomNumber, Car car) {
        if (isPossibleToMove(randomNumber)) {
            car.move();
        }
    }

    public boolean isPossibleToMove(int randomNumber) {
        return randomNumber >= 4;
    }
}
