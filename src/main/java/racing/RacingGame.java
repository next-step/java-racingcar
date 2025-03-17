package racing;

import java.util.List;
import utils.RandomUtils;

public class RacingGame {

    private static final int MOVE_CONDITION = 4;
    private List<Car> cars;
    private int maxRandomNumber;

    public RacingGame(List<Car> cars, int maxRandomNumber) {
        this.maxRandomNumber = maxRandomNumber;
        this.cars = cars;
    }

    public void rollTheDice() {
        for (Car car : cars) {
            int diceResult = RandomUtils.getRandomNumber(this.maxRandomNumber);
            if (diceResult >= MOVE_CONDITION) {
                car.move();
            }
        }
    }

}
