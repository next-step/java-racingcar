package step3.view;

import step3.game.CarName;
import step3.game.PositiveNumber;

import java.util.Set;

public interface InputView {

    String read();

    PositiveNumber tryCount();

    @Deprecated
    PositiveNumber carCount();

    Set<CarName> carNames();
}
