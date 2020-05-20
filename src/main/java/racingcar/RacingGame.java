package racingcar;

import java.util.List;

public class RacingGame {

    private int time;
    private Cars cars;
    private CarMover mover;

    public RacingGame(int time, List<Car> cars) {
        validate(cars.size());

        this.time = time;
        this.cars = new Cars(cars);
        this.mover = new CarMover(new RandomMoveStrategy());
    }

    public RacingResult run() {
        RacingResult results = new RacingResult();

        while (time > 0) {
            canMove();
            cars = mover.move(cars);
            results.add(cars);
            time--;
        }

        return results;
    }

    private void validate(int carSize) {
        if (carSize < 1) {
            throw new IllegalArgumentException(String.format("자동차 수는 1 이상이어야 합니다. : %d", carSize));
        }
    }

    private void canMove() {
        if (time < 1) {
            throw new IllegalStateException("남은 자동차 이동 횟수가 0 이하입니다.");
        }
    }

}
