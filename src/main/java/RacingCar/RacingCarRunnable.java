package RacingCar;

import java.util.Random;

public class RacingCarRunnable implements Runnable {
    private final Car car;
    private final int raceCount;
    private Random random;

    public RacingCarRunnable(Car car, int raceCount) {
        this.car = car;
        this.raceCount = raceCount;
        this.random = new Random();
    }

    @Override
    public void run() {
        runOrStop(getRandomNumber());
    }

    public int runOrStop(int randomNum) {
        int currentPosition = car.getCurrentPosition();

        if (isRunnable(randomNum)) {
            currentPosition++;
        }

        car.setCurrentPosition(currentPosition);

        return currentPosition;
    }

    public boolean isRunnable(int num) {
        return (num >= 4);
    }

    public int getRandomNumber() {
        return random.nextInt(10);
    }

    public void printRacingCarResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getCurrentPosition(); i++) {
            sb.append("-");
        }
        System.out.println(car.getId() + "번 차 : " + sb.toString());
    }
}
