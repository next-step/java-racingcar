package racing.controller;

import racing.domain.GameCondition;
import racing.domain.RacingCar.Name;
import racing.domain.RacingCars;
import racing.domain.RoundResult;
import racing.view.ResultView;

import java.util.List;
import java.util.stream.Stream;

public class RacingGame {

    private static final String EXECUTE_RESULT_MESSAGE = "\n실행 결과";
    private final int totalRounds;
    private final RacingCars racingCars;

    public RacingGame(GameCondition gameCondition) {
        this.totalRounds = gameCondition.getTotalRounds();
        this.racingCars = new RacingCars(gameCondition.getTotalRacingCarCount());
    }

    public List<Name> gameStart() {
        ResultView.printMessage(EXECUTE_RESULT_MESSAGE);
        return Stream.generate(this.racingCars::roundFight)
                .limit(totalRounds)
                .reduce(RoundResult::printAndCombined)
                .orElseThrow()
                .printResultsByName()
                .getWinners();
    }
}
