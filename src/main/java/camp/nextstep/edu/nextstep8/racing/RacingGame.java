package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;
import camp.nextstep.edu.nextstep8.racing.rule.RandomForwardingRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String SEPARATOR = ",";

    private int roundTimes;
    private List<RacingCar> entryList;
    private List<RacingEntry> record = new ArrayList<>();

    public RacingGame(String cars, int roundTimes) {
        this.entryList = generateEntryList(cars);
        this.roundTimes = roundTimes;
    }

    public List<RacingEntry> raceStart() {
        RacingEntry entry = new RacingEntry(entryList);
        for(int i = 0; i < roundTimes; i++){
            entry.move(getRaceRule());
            record.add(entry);
        }
        return record;
    }

    public List<RacingCar> generateEntryList(String cars) {
        return Arrays.stream(cars.split(SEPARATOR))
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public ForwardingRule getRaceRule() {
        return new RandomForwardingRule();
    }
}

