package car.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingCars {
    private static final int MOVE_THRESHOLD = 4;

    private final Random random = new Random();

    private final List<RacingCar> racingCars = new ArrayList<>();

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void addCars(String[] carNameList) {
        Arrays.stream(carNameList)
                .forEach( it ->
                        racingCars.add(new RacingCar(it))
                );
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
