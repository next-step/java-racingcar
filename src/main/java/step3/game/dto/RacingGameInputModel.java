package step3.game.dto;

import java.util.List;

import step3.game.domain.CarName;

public class RacingGameInputModel {
    private final List<CarName> carNames;
    private final int times;

    public RacingGameInputModel(List<CarName> carNames, int times) {
        this.carNames = carNames;
        this.times = times;
    }

    public List<CarName> getCarNames() {
        return carNames;
    }

    public int getTimes() {
        return times;
    }

}
