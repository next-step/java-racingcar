package racing.view;

import racing.domain.car.entity.Car;
import racing.domain.car.entity.Cars;
import racing.domain.game.entity.RacingGame;

public interface ResultView {
    void printResult(RacingGame game);

    void printException(Exception e);
}
