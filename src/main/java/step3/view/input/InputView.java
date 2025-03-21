package step3.view.input;

import step3.game.domain.car.CarName;
import step3.game.domain.PositiveNumber;

import java.util.Set;

public interface InputView {

    String read();

    PositiveNumber tryCount();

    @Deprecated
    PositiveNumber carCount();

    Set<CarName> carNames();
}
