package racingGame.participant;

import java.util.List;

public class RoundScore {

    private List<CarScore> carScores;

    public RoundScore(List<CarScore> carScores) {
        this.carScores = carScores;
    }

    public List<CarScore> getRecords() {
        return carScores;
    }
}