package racing;

import java.util.List;
import java.util.Random;
import utils.RandomUtils;

public class RacingGame {

    private List<Car> cars;
    private int maxRandomNumber;
    private RandomUtils randomUtils;

    public RacingGame(List<Car> cars, int maxRandomNumber) {
        this.maxRandomNumber = maxRandomNumber;
        this.cars = cars;
        Random random = new Random();
        this.randomUtils = new RandomUtils(random);
    }

    public void rollTheDice() {
        for (Car car : cars) {
            int diceResult = randomUtils.getRandomNumber(this.maxRandomNumber);
            car.move(diceResult);
        }
    }

}
