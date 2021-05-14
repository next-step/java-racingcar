package racingcar;

import java.util.List;
import java.util.Random;

public class RacingGame {
    public void playRacing(Random random, List<Car> carList) {
        for (Car car : carList) {
            int movableNum = random.nextInt(10);

            car.move(movableNum);
            System.out.println(car.getCarName() + " : " + car.getMoveString());
        }
    }
}
