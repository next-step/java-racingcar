package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racinggame.Car.CarDto;

public class SnapShotStore {

    private final List<List<CarDto>> snapShot = new ArrayList<>();

    public void save(List<CarDto> result) {
        snapShot.add(result);
    }

    public SnapShot snapShot() {
        return new SnapShot();
    }

    class SnapShot {

        public List<CarDto> getSnapShot(int index) {
            return Collections.unmodifiableList(snapShot.get(index));
        }

        public int repeatCount() {
            return snapShot.size();
        }
    }
}
