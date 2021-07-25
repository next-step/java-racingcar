package racing.view;

import racing.domain.car.Cars;

public class FakeInputView implements InputView {
    private Cars cars;
    private int turnSize;

    public FakeInputView(Cars cars, int turnSize) {
        this.cars = cars;
        this.turnSize = turnSize;
    }

    @Override
    public Cars inputCars() {
        return cars;
    }

    @Override
    public int inputTurnSize() {
        return turnSize;
    }
}