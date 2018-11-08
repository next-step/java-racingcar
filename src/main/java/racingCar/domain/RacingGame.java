package racingCar.domain;

import racingCar.Car;

import java.util.ArrayList;
import java.util.List;

import static racingCar.domain.RacingCarUtil.createRandomValue;
import static racingCar.domain.RacingCarUtil.splitList;

public class RacingGame {

    private List<Car> carList = new ArrayList<Car>();

    public RacingGame(String names) {
        for (String name : splitList(names)) {
            carList.add(new Car(name));
        }
    }

    public GameResult move() {
        for (Car car : carList){
            car.move(createRandomValue());
        }
        return new GameResult(carList);
    }

    public List<Car> getCarList() {
        return carList;
    }

}
