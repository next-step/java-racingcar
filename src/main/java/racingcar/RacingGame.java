package racingcar;

import java.util.ArrayList;
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

    public List<Cars> run() {
        List<Cars> results = new ArrayList<>();

        while (time > 0) {
            canMove();
            cars = mover.move(cars);
            results.add(new Cars(cars));
            time--;
        }

        return results;
    }

    private void validate(int time, int carSize) {
        if (time < 1) {
            throw new IllegalArgumentException(String.format("이동 횟수는 1 이상이어야 합니다. : %d", time));
        }

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
