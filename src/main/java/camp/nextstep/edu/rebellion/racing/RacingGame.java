package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import camp.nextstep.edu.rebellion.racing.rule.RandomMoveRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Entry entry;
    private final Record record;
    private final int rounds;

    public RacingGame(int carNumbers, int rounds) {
        this.rounds = rounds;
        this.entry = enroll(carNumbers);
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

    private Entry enroll(int entryNumbers) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < entryNumbers; i++) {
            cars.add(new RacingCar(String.valueOf(i)));
        }
        return new Entry(cars);
    }
}
