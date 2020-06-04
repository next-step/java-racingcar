package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;

import java.util.List;

public class RacingEntry {
    private final List<RacingCar> entryList;

    public RacingEntry(List<RacingCar> entryList) {
        this.entryList = entryList;
    }

    public void move(ForwardingRule forwardingRule) {
        entryList.forEach(car -> car.move(forwardingRule));
    }

    public List<RacingCar> getEntryList() {
        return entryList;
    }
}

