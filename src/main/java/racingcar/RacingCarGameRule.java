package racingcar;

import racingcar.model.Car;
import racingcar.ui.ResultView;
import java.util.List;

public class RacingCarGameRule {
    private static final int MOVE_CONDITION = 3;
    private static RacingCarGameRule instance = new RacingCarGameRule();

    private RacingCarGameRule() {

    }

    public static RacingCarGameRule getInstance() {
        return instance;
    }

    public void moveCars(List<Car> cars) {
        cars.stream().forEach(car -> car.move(isMovingForward(RandomManaager.getInstance().getRandomValue())));
        ResultView.getInstance().printMove(cars);
        ResultView.getInstance().printLineBreak();
    }

    public boolean isMovingForward(int value) {
        return value > MOVE_CONDITION;
    }
}
