package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int time;
    private int[] carPositions;
    private List<Car> cars;

    public int[] move() {
        canMove();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int position = car.move();
            carPositions[i] = position;
        }

        time--;
        return carPositions;
    }

    private void canMove() {
        if (time < 1) {
            throw new IllegalStateException("남은 자동차 이동 횟수가 0 이하입니다.");
        }
    }

    public void ready(int time, int carCount) {
        validate(time, carCount);

        this.time = time;
        this.carPositions = new int[carCount];
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void validate(int time, int carCount) {
        if (time < 1 || carCount < 1) {
            throw new IllegalArgumentException(String.format("이동 횟수와 자동차 수는 1 이상이어야 합니다. : %d, %d", time, carCount));
        }
    }

}
