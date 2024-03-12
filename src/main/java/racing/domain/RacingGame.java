package racing.domain;

import racing.Constant;
import racing.utils.RandomUtil;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final List<Car> cars;
    private final int chance;

    public RacingGame(List<Car> cars, int chance) {
        this.cars = cars;
        this.chance = chance;
    }

    public void validateInput(int cars, int chances) {
        if (cars <= 0) {
            throw new IllegalArgumentException(Constant.CAR_NUMBER_VALIDATION_ERROR);
        }

        if (chances <= 0) {
            throw new IllegalArgumentException(Constant.CHANCE_NUMBER_VALIDATION_ERROR);
        }
    }

    public List<Car> play() {
        IntStream.range(0, chance)
                .forEach(i -> cars.forEach(car -> car.move(RandomUtil.generateRandomNumber())));
        return cars;
    }

}
