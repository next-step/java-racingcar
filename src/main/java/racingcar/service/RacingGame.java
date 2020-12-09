package racingcar.service;

import racingcar.domain.MoveRule;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingRound;
import racingcar.domain.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int countOfRound;
    private RacingCars racingCars;
    private List<RacingRound> racingRounds = new ArrayList<>();
    private MoveRule moveRule = new RacingRule();

    public RacingGame(List<String> carNames, int countOfRound) {
        this.racingCars = new RacingCars(carNames);
        this.countOfRound = countOfRound;
    }

    public List<RacingRound> start() {
        for (int i = 0; i < countOfRound; i++) {
            racingRounds.add(racingCars.racing(adjustRule()));
        }
        return racingRounds;
    }

    public List<RacingRound> getRacingResult() {
        return this.racingRounds;
    }

    public MoveRule adjustRule() {
        return this.moveRule;
    }

}
