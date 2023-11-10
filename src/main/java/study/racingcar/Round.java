package study.racingcar;


import java.util.stream.Collectors;

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
