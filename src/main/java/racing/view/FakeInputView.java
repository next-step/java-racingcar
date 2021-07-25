package racing.view;

import racing.domain.car.entity.Cars;
import racing.domain.game.entity.RacingGame;

public class FakeInputView implements InputView {
    private Cars cars;
    private int turnSize;

    public FakeInputView(Cars cars, int turnSize) {
        this.cars = cars;
        this.turnSize = turnSize;
    }

    public Cars inputCars() {
        return cars;
    }

    @Override
    public RacingGame inputRacingGame() {
        return null;
    }
}