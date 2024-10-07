package racinggame.dto;

import java.util.Collections;
import java.util.List;
import racinggame.domain.SnapShot;

public class SnapShotDto {
    private final List<SnapShot> snapShots;

    public SnapShotDto(List<SnapShot> snapShots) {
        this.snapShots = snapShots;
    }

    public List<CarDto> getSnapShot(int index) {
        SnapShot snapShot = snapShots.get(index);
        return Collections.unmodifiableList(snapShot.history());
    }

    public int repeatCount() {
        return snapShots.size();
    }

}
