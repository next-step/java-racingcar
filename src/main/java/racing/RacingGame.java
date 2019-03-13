package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    // 운행횟수
    private int time;
    // Car 컬렉션
    private List<Car> cars;

    RacingGame(final int time, final int carCount) {
        this.time = time;
        this.cars = new ArrayList<Car>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public int getTime() {
        return this.time;
    }

    public List<Car> getList() {
        return Collections.unmodifiableList(this.cars);
    }

    public RacingGameResult racingGameResult() {
        return new RacingGameResult(time, cars);
    }

    public void runRacingGame(GameRule gameRule) {
        for (int i = 0; i < time; i++) {
            for (Car car : cars) {
                car.move(gameRule.moveRacingGameRule(), i);
            }
        }
    }
}