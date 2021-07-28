package racing.domain.dto;

import racing.domain.car.Cars;

public class FakeGameRequest extends GameRequest {
    private Cars cars;
    public FakeGameRequest(Cars cars, int turnSize) {
        super(null, turnSize);
        this.cars = cars;
    }

    @Override
    public Cars cars() {
        return cars;
    }
}
