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
    private RacingEntry entry;

    public RacingGame(String cars, int roundTimes) {
        this.entry = new RacingEntry(generateEntryList(cars));
        this.roundTimes = roundTimes;
    }

    public List<RacingEntry> raceStart() {
        List<RacingEntry> record = new ArrayList<>();
        for(int i = 0; i < roundTimes; i++) {
            entry.move(getRaceRule());
            record.add(getSnapShot(entry));
        }

        return Collections.unmodifiableList(record);
    }

    public ForwardingRule getRaceRule() {
        return new RandomForwardingRule();
    }

    private List<RacingCar> generateEntryList(String cars) {
        return Arrays.stream(cars.split(SEPARATOR))
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private RacingEntry getSnapShot(RacingEntry origin) {
        List<RacingCar> snapShotEntryList = new ArrayList<>();
        for(RacingCar orginCar : origin.getEntryList()) {
            snapShotEntryList.add(orginCar.getSnapShot());
        }
        return new RacingEntry(snapShotEntryList);
    }
}

