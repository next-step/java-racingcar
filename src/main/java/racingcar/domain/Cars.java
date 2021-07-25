package racingcar.domain;

import racingcar.utils.CreateRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private int winnerPosition;

    public Cars(String[] carNames) {
        winnerPosition = 0;
        createCar(carNames);
    }

    private void createCar(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getWinnerPosition() {
        return winnerPosition;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(CreateRandomNumber.getRandomNumber());
            winnerPosition = Math.max(winnerPosition,car.getPosition());
        }
    }
}
