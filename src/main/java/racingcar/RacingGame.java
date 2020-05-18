package racingcar;

import java.util.List;

public class RacingGame {

    private int time;
    private List<Car> cars;
    private CarMover mover;

    public RacingGame(int time, List<Car> cars) {
        validate(time, cars.size());

        this.time = time;
        this.cars = cars;
        this.mover = new CarMover(new RandomMoveStrategy());
    }

    private void validate(int time, int carCount) {
        if (time < 1 || carCount < 1) {
            throw new IllegalArgumentException(String.format("이동 횟수와 자동차 수는 1 이상이어야 합니다. : %d, %d", time, carCount));
        }
    }

    public MoveResults run() {
        MoveResults results = new MoveResults();

        while (time > 0) {
            canMove();
            CarPositions positions = mover.move(cars);
            results.add(positions);
            time--;
        }

        return results;
    }

    private void canMove() {
        if (time < 1) {
            throw new IllegalStateException("남은 자동차 이동 횟수가 0 이하입니다.");
        }
    }

}
