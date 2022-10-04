package racingCar.step3;

import java.util.Random;

public class RacingCar {
    private int numberOfMovement = 0;
    private final Random random;

    public RacingCar(long randomSeed) {
        this.random = new Random(randomSeed);
    }

    public void tryMove() {
        if (canMove(random.nextInt(10))) {
            numberOfMovement++;
        }
    }

    public boolean canMove(int randomNumber) {
        return 4 <= randomNumber;
    }

    public int movements() {
        return numberOfMovement;
    }
}
