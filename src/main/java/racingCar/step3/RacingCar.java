package racingCar.step3;

import java.util.Random;

public class RacingCar {
    private int numberOfMovement = 0;

    private String name;

    private final Random random;

    public RacingCar(String name, long randomSeed) {
        validateName(name);
        this.name = name;
        this.random = new Random(randomSeed);
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
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
