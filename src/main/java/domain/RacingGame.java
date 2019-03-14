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
        if(getRule() == null || getGameCount() == null || getCars().size() == 0){
            throw new IllegalStateException("Have to init first");
        }

        RacingGameResult racingGameResult = new RacingGameResult();

        IntStream.rangeClosed(1, getGameCount())
            .mapToObj(this::playCycle)
            .forEach(racingGameResult::addRoundResult);

        racingGameResult.createRanking(getCars());

        return racingGameResult;
    }

    private RoundResult playCycle(int roundNumber){
        getCars().stream()
            .filter(c -> getRule().canPass())
            .forEach(Car::move);

        return new RoundResult(roundNumber, getCars().stream()
            .map(CarResult::new)
            .collect(Collectors.toList()));
    }
}
