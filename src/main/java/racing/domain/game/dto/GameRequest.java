package racing.domain.game.dto;

import racing.domain.car.entity.Cars;
import racing.domain.game.vo.Turns;
import racing.util.converter.CarsConverter;
import racing.util.converter.TurnsConverter;


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

    public Turns turns() {
        return TurnsConverter.getInstance().convert(turnSize);
    }
}
