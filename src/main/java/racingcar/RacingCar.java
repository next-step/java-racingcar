package racingcar;

import java.util.Objects;
import java.util.Random;

public class RacingCar {

    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_RANGE = 10;

    private Random random = new Random();
    private int carPosition;

    public RacingCar() {
    }

    public RacingCar(int carPosition) {
        this.carPosition = carPosition;
    }

    public RacingCar run() {
        if(checkRule()) {
            carPosition++;
        }
        return new RacingCar(this.carPosition);
    }

    public boolean checkRule() {
        return MOVE_CONDITION <= random.nextInt(RANDOM_NUMBER_RANGE);
    }

    public int getCarPosition() {
        return carPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carPosition == racingCar.carPosition &&
                Objects.equals(random, racingCar.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPosition, random);
    }
}
