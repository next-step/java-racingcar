package racingcar;

import java.util.List;
import java.util.Random;

public class RacingGame {
    public void playRacing(List<Car> carList) {
        Random random = new Random();

        for (Car car : carList) {
            int movableNum = random.nextInt(10);

            car.move(movableNum);
            System.out.println(car.getCarName() + " : " + car.getMoveString());
        }
    }
}
