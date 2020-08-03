package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import camp.nextstep.edu.rebellion.racing.rule.RandomMoveRule;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String DELIMITER = ",";

    private final Entry entry;
    private final Record record;
    private final int rounds;

    public RacingGame(String cars, int rounds) {
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

    private Entry enroll(String cars) {
        return Arrays.stream(cars.split(DELIMITER))
                .map(RacingCar::new)
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(), Entry::new));
    }
}
