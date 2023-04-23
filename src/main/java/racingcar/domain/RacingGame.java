package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final GameRound gameRound;

    public RacingGame(GameRound gameRound) {
        this.gameRound = gameRound;
    }


    public List<Scores> startGame(Cars cars, NumberGeneratorStrategy numberGeneratorStrategy) {
        return IntStream.range(0, gameRound.getGameRound())
                .mapToObj(i -> race(cars, numberGeneratorStrategy))
                .collect(Collectors.toList());
    }

    public Scores race(Cars cars, NumberGeneratorStrategy numberGeneratorStrategy) {
        return cars.move(numberGeneratorStrategy);
    }
}
