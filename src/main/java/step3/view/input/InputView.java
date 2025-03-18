package step3.view.input;

import step3.game.car.CarName;
import step3.game.PositiveNumber;

import java.util.Set;

public interface InputView {

    String read();

    PositiveNumber tryCount();

    @Deprecated
    PositiveNumber carCount();

    Set<CarName> carNames();
}
