package racinggame.dto;

import racinggame.domain.Car;

import java.util.List;

public class RacingRoundResultDTO {

    private final int racingRound;
    private final List<Car> cars;

    public RacingRoundResultDTO(int racingRound, List<Car> cars) {
        this.racingRound = racingRound;
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
