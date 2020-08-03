package camp.nextstep.edu.rebellion.racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Record {
    private final List<SnapShotEntry> snapShots = new ArrayList<>();
    public void keep(Entry entry) {
        snapShots.add(entry.getSnapshot());
    }

    public List<SnapShotEntry> getSnapShots() {
        return Collections.unmodifiableList(this.snapShots);
    }

    public SnapShotEntry getFinalRoundSnapShot() {
        return snapShots.get(snapShots.size() - 1);
    }
}
