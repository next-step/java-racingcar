package racing.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<RacingScore> racingScores = new ArrayList<>();

    private RacingResult() {}

    public static RacingResult initRacingScore(RacingScore racingScore) {
        RacingResult racingResult = new RacingResult();
        racingResult.racingScores.add(racingScore);
        return racingResult;
    }

    public List<RacingScore> getEntireRacingScore() {

        return racingScores;
    }

    public void addCurrentRacingScore(RacingScore racingScore) {

        racingScores.add(racingScore);
    }

    public RacingScore getLastRacingScore() {

        return racingScores.get(racingScores.size() - 1);
    }
}
