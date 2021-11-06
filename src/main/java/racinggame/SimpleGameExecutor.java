package racinggame;

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
        return startGame(inputValue.attempts(), racingCars);
    }

    private ResultViews startGame(int attempts, RacingCars racingCars) {
        List<ResultView> resultViews = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            racingCars.advance();
            resultViews.add(racingCars.advanceStatus());
        }

        return new ResultViews(resultViews);
    }
}
