package racingcar.dto;

import racingcar.domain.RacingScore;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarResponseDto {
    private final List<RacingScore> racingScores;
    private final List<Car> winners;

    public RacingCarResponseDto(List<RacingScore> racingScores, List<Car> winners) {
        this.racingScores = Collections.unmodifiableList(racingScores);
        this.winners = Collections.unmodifiableList(winners);
    }

    public List<RacingScore> getRacingScores() {
        return racingScores;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
