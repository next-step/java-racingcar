package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarDriver {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_MIN_VALUE = 4;
    private final Random random = new Random();

    private List<RacingCar> racingCars;

    public RacingCarDriver(int amount) {
        this(RacingCarDriver.createRacingCars(amount));
    }

    public RacingCarDriver(List<RacingCar> racingCars) {
        if (racingCars != null) {
            this.racingCars = racingCars;
        }
    }

    /**
     * 주어진 수 만큼 자동차를 만들어 리스트에 담아 리턴합니다.
     * @param amount
     * @return
     */
    public static List<RacingCar> createRacingCars(int amount) {
        List<RacingCar> racingCars = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            racingCars.add(new RacingCar());
        }
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
        return this.random.nextInt(RacingCarDriver.RANDOM_BOUND);
    }

    /**
     * 주어진 값이 전진해야하는 조건이 맞는지 체크합니다.
     * @param value
     * @return
     */
    boolean isMovable(int value) {
        return value >= MOVABLE_MIN_VALUE;
    }

    /**
     * 자동차의 현재 위치를 받아서 리스트에 담습니다.
     * @return
     */
    public List<Integer> getNowDistance() {
        List<Integer> nowDistances = new ArrayList<>();
        for (RacingCar racingCar : this.racingCars) {
            nowDistances.add(racingCar.getDistance());
        }
        return nowDistances;
    }
}
