package racingcar.step4;

import java.util.List;

public class Race {
    public static void startRaceGame(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomUtil.generateRandomNumber();
            car.move(randomNumber);
        }
    }
}
