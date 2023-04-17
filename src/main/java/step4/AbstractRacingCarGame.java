package step4;

import step4.domain.CarRacingType;
import step4.strategy.move.MoveStrategy;
import step4.view.InputView;

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
