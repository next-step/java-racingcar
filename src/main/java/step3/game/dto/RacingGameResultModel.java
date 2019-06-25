package step3.game.dto;

import java.util.List;

import step3.game.domain.Cars;
import step3.game.domain.Winners;

public class RacingGameResultModel {
    private final List<Cars> cars;
    private final Winners winners;

    public RacingGameResultModel(List<Cars> cars, Winners winners) {
        this.cars = cars;
        this.winners = winners;
    }

    public List<Cars> getCars() {
        return cars;
    }

    public Winners getWinners() {
        return winners;
    }
}
