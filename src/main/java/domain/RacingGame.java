package domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.experimental.Delegate;

public class RacingGame {
    @Delegate
    private RacingGameInfo racingGameInfo;

    public RacingGame(RacingGameInfo racingGameInfo) {
        this.racingGameInfo = racingGameInfo;
    }

    public RacingGameResult play(){
        RacingGameResult racingGameResult = new RacingGameResult();

        IntStream.rangeClosed(1, getGameCount())
            .mapToObj(this::playCycle)
            .forEach(racingGameResult::addRoundResult);

        racingGameResult.createRanking(getCars());

        return racingGameResult;
    }

    private RoundResult playCycle(int roundNumber){
        getCars().forEach(c -> c.move(getRule()));

        return new RoundResult(roundNumber, getCars().stream()
            .map(CarResult::new)
            .collect(Collectors.toList()));
    }
}
