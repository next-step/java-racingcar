package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int time;
    private List<Car> cars;
    private CarMover mover;

    public RacingGame(int time, int carCount) {
        validate(time, carCount);

        this.time = time;
        this.cars = new ArrayList<>();
        this.mover = new CarMover();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void validate(int time, int carCount) {
        if (time < 1 || carCount < 1) {
            throw new IllegalArgumentException(String.format("이동 횟수와 자동차 수는 1 이상이어야 합니다. : %d, %d", time, carCount));
        }
    }

    public RacingResult run() {
        RacingResult result = new RacingResult();

        while (time > 0) {
            canMove();
            int[] positions = mover.move(cars);
            result.add(positions);
            time--;
        }

        return result;
    }

    private void canMove() {
        if (time < 1) {
            throw new IllegalStateException("남은 자동차 이동 횟수가 0 이하입니다.");
        }
    }

}
