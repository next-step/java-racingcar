package racingcar.domain.round;

import racingcar.domain.car.Cars;
import racingcar.dto.RoundResults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rounds {
    private final List<Round> rounds;

    public Rounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public Rounds(Cars cars, Integer roundCount) {
        this.rounds = new ArrayList<>();

        for (int i = 0; i < roundCount; i++) {
            rounds.add(new Round(cars));
        }
    }

    public RoundResults play() {
        return new RoundResults(rounds.stream().map(Round::play).collect(Collectors.toList()));
    }
}
