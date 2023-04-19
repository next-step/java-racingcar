package step5;

import step5.domain.CarRacingType;
import step5.strategy.move.MoveStrategy;
import step5.view.InputView;

public abstract class AbstractRacingCarGame<T> {

    public final void execute() {
        showResult(play(getRacingInformation()));
    }

    abstract T getRacingInformation();

    abstract T play(T racingInformation);

    abstract void showResult(T racingInformation);

    public static AbstractRacingCarGame of(CarRacingType carRacingType, InputView inputView, MoveStrategy moveStrategy) {
        return carRacingType.of(inputView, moveStrategy);
    }
}
