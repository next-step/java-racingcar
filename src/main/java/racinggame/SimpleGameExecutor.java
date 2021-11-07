package racinggame;

import racinggame.utils.CarFactory;
import racinggame.view.ResultView;
import racinggame.view.ResultViews;

import java.util.ArrayList;
import java.util.List;

public class SimpleGameExecutor implements GameExecutor {

    private final InputValue inputValue;

    public SimpleGameExecutor(InputValue inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public ResultViews execute() {
        RacingCars racingCars = CarFactory.createRacingCars(inputValue.cars());
        return null;
    }


}
