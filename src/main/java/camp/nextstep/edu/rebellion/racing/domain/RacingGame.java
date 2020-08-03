package camp.nextstep.edu.rebellion.racing.domain;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import camp.nextstep.edu.rebellion.racing.rule.RandomMoveRule;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Entry entry;
    private final Record record;
    private final int rounds;

    public RacingGame(List<String> cars, int rounds) {
        this.rounds = rounds;
        this.entry = enroll(cars);
        this.record = new Record();
    }

    public Record start() {
        for (int i = 0; i < rounds; i++) {
            entry.move(applyRule());
            record.keep(entry);
        }
        return record;
    }

    public RacingRule applyRule() {
        return new RandomMoveRule();
    }

    private Entry enroll(List<String> cars) {
        return cars
                .stream()
                .map(RacingCar::new)
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(), Entry::new));
    }
}
