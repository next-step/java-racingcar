package car.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {
    private static final int MOVE_THRESHOLD = 4;

    private final Random random = new Random();

    private List<RacingCar> racingCars = new ArrayList<>();

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void addCars(int carCount) {
        for (int i = 0; i < carCount; ++i) {
            racingCars.add(new RacingCar());
        }
    }

    private void tryMoving(RacingCar racingCar) {
        if (canMove()) {
            racingCar.move();
        }
    }

    private boolean canMove() {
        return random.nextInt(10) >= MOVE_THRESHOLD;
    }

    public void runRound() {
        racingCars.forEach(this::tryMoving);
    }
}
