package racing.domain;

import java.util.List;
import java.util.Random;

public class RacingGame {

    public RacingGame(int number, List<Car> carList) {
        new TryCount(number);
        new Cars(carList);
    }

    public void carMove(List<Car> cars) {
        final int RANDOM_MAX = 10;
        Random random = new Random();

        for (Car  car : cars) {
            car.move(random.nextInt(RANDOM_MAX));
        }
    }
}
