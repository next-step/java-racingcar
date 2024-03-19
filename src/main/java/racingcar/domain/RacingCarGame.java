package racingcar.domain;

import racingcar.domain.dto.RacingResult;
import racingcar.domain.dto.RoundResult;
import racingcar.domain.dto.RoundScore;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.StrategyRandomMove;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    private final List<Car> carList;
    private final StrategyRandomMove strategyRandomMove = new StrategyRandomMove();

    public RacingCarGame(List<Car> carList) {
        this.carList = carList;
    }

    public static RacingCarGame from(int carCount) {
        return new RacingCarGame(createCarList(carCount));
    }
    public static List<Car> createCarList(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public RacingResult executeRacing(int trialCount) {
        List<RoundResult> roundResults = new ArrayList<>();
        while (trialCount-- > 0) {
            roundResults.add(executeRound());
        }
        return new RacingResult(roundResults);
    }

    public RoundResult executeRound() {
        play(strategyRandomMove);
        return new RoundResult(getRoundResults());
    }

    private List<RoundScore> getRoundResults() {
        return carList.stream()
                .map(car -> new RoundScore(car.getPosition()))
                .collect(Collectors.toList());
    }

    private void play(MoveStrategy moveStrategy) {
        carList.forEach(car -> car.moveForward(moveStrategy));
    }
}
