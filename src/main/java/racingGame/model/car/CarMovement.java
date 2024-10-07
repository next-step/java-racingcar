package racingGame.model.car;

import java.util.ArrayList;
import java.util.List;

public class CarMovement {
    private List<Cars> progress;

    public CarMovement() {
        progress = new ArrayList<>();
    }

    public void addOneStepProgress(Cars cars) {
        this.progress.add(cars.clone());
    }

    public List<Cars> getProgress() {
        return this.progress;
    }

}
