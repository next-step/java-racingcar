package step3;

import step3.domain.CarRacingType;
import step3.strategy.move.MoveStrategy;
import step3.view.InputView;

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
