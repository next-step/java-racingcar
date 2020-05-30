package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.RandomForwardingRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int carNumbers;
    private int raceTimes;
    private List<Integer> record;

    public RacingGame(int carNumbers, int raceTimes) {
        this.carNumbers = carNumbers;
        this.raceTimes = raceTimes;
        this.record = new ArrayList<>();
    }

    public List<Integer> raceStart() {
        RacingEntry entry = new RacingEntry(generateRandomRuleEntryList(carNumbers));
        for(int i = 0; i < raceTimes; i++){
            entry.move();
            record(entry);
        }
        return record;
    }

    public List<RacingCar> generateRandomRuleEntryList(int carNumbers) {
        List<RacingCar> entryList = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++){
            entryList.add(new RacingCar(new RandomForwardingRule()));
        }
        return entryList;
    }

    private void record(RacingEntry entry) {
        for(RacingCar racingCar : entry.getEntryList()) {
            record.add(racingCar.getPosition());
        }
    }
}

