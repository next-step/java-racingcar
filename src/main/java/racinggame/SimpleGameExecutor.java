package racinggame;

import racinggame.utils.CarFactory;

import java.util.List;

public class SimpleGameExecutor implements GameExecutor {

    private final InputValue inputValue;

    public
    SimpleGameExecutor(InputValue inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public List<MoveResult> execute() {
        RacingCars racingCars = CarFactory.createRacingCars(inputValue);
        return racingCars.move(inputValue.attempts())
                .getRacingResult();

    }


}
