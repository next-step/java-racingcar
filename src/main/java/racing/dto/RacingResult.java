package racing.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<RacingScore> racingScores = new ArrayList<>();

    public List<RacingScore> getEntireRacingScore() {

        return racingScores;
    }

    public void addCurrentRacingScore(EntireCars entireCars) {

        racingScores.add(RacingScore.of(entireCars));
    }

    public RacingScore getLastRacingScore() {

        return racingScores.get(racingScores.size() - 1);
    }
}
