package racingcar;

import java.util.*;


public class RacingGame {
    private static final int RANDOM_FROM = 0;
    private static final int RANDOM_TO = 9;

    private List<Car> cars;
    private final int tryNo;
    private int round;

    public RacingGame(String[] carNames, int tryNo) {
        this.tryNo = tryNo;
        this.round = 0;
        cars = new ArrayList<>(carNames.length);
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public RacingResult race() {
        this.round++;
        move(new RandomUtil(RANDOM_FROM, RANDOM_TO));
        return new RacingResult(cars);

    }

    public void move(RandomUtil randomUtil) {
        cars.stream()
            .forEach(car -> car.go(randomUtil.randomInt()));
    }

    public boolean isEnd() {
        if(this.round == tryNo) return true;

        return false;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
