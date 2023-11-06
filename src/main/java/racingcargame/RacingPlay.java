package racingcargame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingPlay {

    private static Random random = new Random();

    public List<Car> readyForRacing(int carNumber) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car(""));
        }

        return carList;
    }

    public List<Car> playRacingCar(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            int randomNumber = random.nextInt(10);
            moveForward(randomNumber, carList.get(i));
        }

        return carList;
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
