package racing.dto;

import racing.domain.EntireCars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingScore {

    private List<CarNamePosition> carNamePositions;

    private RacingScore() {}

    public static RacingScore of(EntireCars entireCars) {

        RacingScore racingScore = new RacingScore();
        racingScore.carNamePositions = entireCars.getCars()
                .stream()
                .map(CarNamePosition::of)
                .collect(Collectors.toList());
        return racingScore;
    }

    public List<CarNamePosition> getCarNamePositions() {

        return carNamePositions;
    }
}
