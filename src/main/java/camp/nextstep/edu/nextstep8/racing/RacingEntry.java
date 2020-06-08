package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingEntry {
    private final List<RacingCar> entryList;

    public RacingEntry(List<RacingCar> entryList) {
        this.entryList = entryList;
    }

    public void move(ForwardingRule forwardingRule) {
        entryList.forEach(car -> car.move(forwardingRule));
    }

    public List<RacingCar> getEntryList() {
        return Collections.unmodifiableList(entryList);
    }

    public String getWinner() {
        return entryList.stream()
                .filter(car -> car.getPosition() >= getWinnerPosition())
                .map(car -> car.getName())
                .collect(Collectors.joining(","));
    }

    private int getWinnerPosition() {
        return entryList.stream()
                .mapToInt(c -> c.getPosition())
                .max().getAsInt();
    }
}

