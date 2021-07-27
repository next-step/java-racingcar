package racing.domain.dto;

import racing.domain.car.Cars;
import racing.util.converter.CarsConverter;


public class GameRequest {
    private final String carNames;
    private final int turnSize;

    public GameRequest(String carNames, int turnSize) {
        this.carNames = carNames;
        this.turnSize = turnSize;
    }

    public Cars cars() {
        return CarsConverter.getInstance().convert(carNames);
    }

    public int turnSize() {
        return turnSize;
    }
}
