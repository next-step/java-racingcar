package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import racinggame.dto.CarDto;
import racinggame.dto.History;

public class SnapShotStore {

    private final List<SnapShot> snapShot = new ArrayList<>();

    public void save(List<CarDto> result) {
        snapShot.add(new SnapShot(result));
    }

    public History snapShot() {
        return new History(snapShot);
    }

}
