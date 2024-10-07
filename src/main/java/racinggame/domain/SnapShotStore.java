package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import racinggame.dto.CarDto;
import racinggame.dto.SnapShotDto;

public class SnapShotStore {

    private final List<SnapShot> snapShot = new ArrayList<>();

    public void save(List<CarDto> result) {
        snapShot.add(new SnapShot(result));
    }

    public SnapShotDto snapShot() {
        return new SnapShotDto(snapShot);
    }

}
