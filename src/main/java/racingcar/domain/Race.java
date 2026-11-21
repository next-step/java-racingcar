package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final Cars cars;
    private final int rounds;
    private final NumberGenerator numberGenerator;
    private final List<RoundResult> roundResults;
    private boolean played;

    public Race(List<String> carNames, int rounds, NumberGenerator numberGenerator) {
        if (rounds < 0) {
            throw new IllegalArgumentException("rounds can not be negative value");
        }
        this.cars = new Cars(carNames);
        this.rounds = rounds;
        this.numberGenerator = numberGenerator;
        this.roundResults = new ArrayList<>();
        this.played = false;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public void play() {
        if (played) {
            throw new IllegalStateException("cannot play again");
        }
        for (int i = 0; i < rounds; i++) {
            roundResults.add(playRound());
        }
        played = true;
    }

    private RoundResult playRound() {
        cars.move(numberGenerator);
        return new RoundResult(cars.getStatuses());
    }
}
