package racingcar.module;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public Cars countOfRound(int tryNum) {
        List<Car> carList = new ArrayList<>();
        for (int num = 0; num < tryNum; num++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }

}
