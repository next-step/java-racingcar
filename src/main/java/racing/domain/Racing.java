package racing.domain;

import racing.domain.strategy.MoveStrategy;
import racing.view.Output;

public class Racing {

    public void racing(Cars cars, Integer countOfTry, MoveStrategy moveStrategy) {
        Output.startOutputView();

        for (int i = 0; i < countOfTry; i++) {
            cars.playRacing(moveStrategy);
            Output.racingOutputView(cars);
        }

        Output.endOutputView(cars);
    }
}
