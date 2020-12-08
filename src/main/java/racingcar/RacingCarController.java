package racingcar;

import java.util.List;
import java.util.Random;

public class RacingCarController {

    private static final int RANDOM_BOUND = 10;
    private final Random random = new Random();

    private final List<RacingCar> racingCars;

    public RacingCarController(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void moveForwardAll() {
        for (RacingCar racingCar : this.racingCars) {
            this.moveForward(racingCar);
        }
    }

    /**
     * 전진해야하는 조건에 맞으면 자동차를 전진시킵니다
     * @return
     */
    int moveForward(RacingCar racingCar) {
        if (this.isMovable(this.makeRandom())) {
            return racingCar.addDistance();
        }
        return racingCar.getDistance();
    }

    /**
     * 0 ~ 9 사이의 랜덤한 숫자를 만듭니다.
     * @return
     */
    private int makeRandom() {
        return this.random.nextInt(RacingCarController.RANDOM_BOUND);
    }

    /**
     * 주어진 값이 전진해야하는 조건이 맞는지 체크합니다.
     * @param value
     * @return
     */
    boolean isMovable(int value) {
        return value >= 4;
    }
}
