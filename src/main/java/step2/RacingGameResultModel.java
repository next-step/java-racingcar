package step2;

import java.util.List;

import step2.game.domain.Cars;

public class RacingGameResultModel {
    private final List<Cars> cars;

    public RacingGameResultModel(List<Cars> cars) {
        this.cars = cars;
    }

    public List<Cars> getCars() {
        return cars;
    }

}
