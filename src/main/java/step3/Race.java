package step3;

import java.util.Random;

public class Race {

    private final RacingCar racingCars;
    private final int trial;
    private static final Random RANDOM = new Random();
    public static final int BOUND = 10;

    public Race(int count, int trial) {
        validate(count, trial);
        this.racingCars = new RacingCar(count);
        this.trial = trial;
    }

    public void start() {
        for (int i = 0; i < this.trial; i++) {
            printRacingResult();
            System.out.println();
        }
    }

    public int getTrial() {
        return trial;
    }

    private void validate(int count, int trial) {
        if (isLessThanZero(count, trial)) {
            throw new IllegalArgumentException("1 이상을 입력해 주세요");
        }
    }

    private void printRacingResult() {
        this.racingCars.getList().forEach(racingCar -> {
                racingCar.move(getRandomNumber());
                System.out.println(racingCar.getDistance());
            }
        );
    }

    private int getRandomNumber() {
        return RANDOM.nextInt(BOUND);
    }

    private boolean isLessThanZero(int count, int trial) {
        return count < 1 || trial < 1;
    }
}
