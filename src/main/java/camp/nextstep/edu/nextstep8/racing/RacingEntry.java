package camp.nextstep.edu.nextstep8.racing;

import java.util.List;

public class RacingEntry {
    private final List<RacingCar> entryList;

    public RacingEntry(List<RacingCar> entryList) {
        this.entryList = entryList;
    }

    public void move() {
        entryList.forEach(RacingCar::move);
    }

    public List<RacingCar> getEntryList() {
        return entryList;
    }
}
