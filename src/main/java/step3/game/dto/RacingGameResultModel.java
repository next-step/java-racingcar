package step3.game.dto;

import java.util.List;

import step3.game.domain.Cars;

public class RacingGameResultModel {
    private final List<Cars> cars;
    private final Cars winners;

    public RacingGameResultModel(List<Cars> cars, Cars winners) {
        this.cars = cars;
        this.winners = winners;
    }

    public List<Cars> getCars() {
        return cars;
    }

    public Cars getWinners() {
        return winners;
    }
}
