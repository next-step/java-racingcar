package racing.controller;

import racing.domain.RacingCars;
import racing.model.GameCondition;
import racing.model.RoundResult;
import racing.view.ResultView;

import java.util.stream.Stream;

public class RacingGame {

    private static final String EXECUTE_RESULT_MESSAGE = "\n실행 결과";
    private final int totalRounds;
    private final RacingCars racingCars;

    public RacingGame(GameCondition gameCondition) {
        this.totalRounds = gameCondition.getTotalRounds();
        this.racingCars = new RacingCars(gameCondition.getTotalRacingCarCount());
    }

    public RoundResult gameStart() {
        ResultView.printNewLineMessage(EXECUTE_RESULT_MESSAGE);
        return Stream.generate(this.racingCars::roundFight)
                .limit(totalRounds)
                .reduce(RoundResult::printAndCombined)
                .orElseThrow()
                .printResultsByName();
    }
}
