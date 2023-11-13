package study.racingcar.domain.round;


import java.util.stream.Collectors;
import study.racingcar.util.RandomGenerator;
import study.racingcar.domain.score.Score;
import study.racingcar.domain.score.ScoreBoard;
import study.racingcar.domain.score.ScoreEachRound;
import study.racingcar.domain.car.Cars;

public class Round {

    private final Cars participateCars;

    public Round(Cars cars) {
        this.participateCars = cars;
    }

    public ScoreEachRound race(ScoreBoard scoreBoard, RandomGenerator randomGenerator) {
        return new ScoreEachRound(participateCars.carlist().stream()
                        .map(car -> new Score(car, randomGenerator))
                        .collect(Collectors.toList())
        );
    }
}
