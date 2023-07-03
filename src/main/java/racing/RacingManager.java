package racing;

import racing.generator.NumberGenerator;

import java.util.List;

public class RacingManager {
    public RacingManager(List<Car> cars, NumberGenerator numberGenerator, int i) {
    }

    public RacingManager() {
    }

    public boolean isMovable(int value) {
        return 4 <= value && value <= 9;
    }

    public List<Car> getCars() {
        return null;
    }

    public void nextStep() {
    }
}
