package race;

import java.util.Random;

public class RacingGame {
    private int time;
    private int countOfCar;
    private int[] carPositions;
    private Random random = new Random();

    private RacingGame(int countOfCar, int time) {
        this.countOfCar = countOfCar;
        this.time = time;
        this.carPositions = new int[countOfCar];
    }

    public static RacingGame of(int countOfCar, int time) {
        return new RacingGame(countOfCar, time);
    }

    public int[] move() {
        for (int i = 0; i < carPositions.length; i++) {
            if(random.nextInt() >= 4) {
                carPositions[i] = carPositions[i] + 1;
            }
        }

        return carPositions;
    }
}