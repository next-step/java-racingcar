package racingcar.step4;

import java.util.List;

public class Race {

    public static List<Car> startRaceGame(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomUtil.generateRandomNumber();
            car.move(randomNumber);
        }

        return cars;
    }

}
