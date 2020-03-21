package racingcar.domain;

import racingcar.utils.RandomUtils;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;

    private int time;
    private List<Car> cars;
    private GameRole gameRole;

    public RacingGame(int time, int carNumber, GameRole gameRole) {
        this.time = time;
        this.cars = new ArrayList<>(carNumber);
        this.gameRole = gameRole;

        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
    }

    public void start() {
        ResultView.printResult();

        for (int i = 0; i < time; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int advanceCount = gameRole.getAdvanceCount(RandomUtils.random(RANDOM_BOUND));

            car.move(advanceCount);
            car.printPosition();
        }

        ResultView.printNewLine();
    }
}
