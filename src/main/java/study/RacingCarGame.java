package study;

import java.util.Random;
public class RacingCarGame {
    RacingCar[] racingCars;
    int rounds;
    int cars;

    public RacingCarGame(int cars, int rounds) {
        this.racingCars = new RacingCar[cars];
        for (int i = 0; i < cars; i++) {
            this.racingCars[i] = new RacingCar(rounds);
        }
        this.rounds = rounds;
        this.cars = cars;
    }

    public int getCars() {
        return this.cars;
    }

    public int getRounds() {
        return this.rounds;
    }

    public RacingCar getRacingCarByIndex(int index) {
        return this.racingCars[index];
    }

    public void run() {
        Random generator = new Random();
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < cars; j++) {
                if (generator.nextInt(10) >= 4) {
                    racingCars[j].moveForward(true);
                }
                racingCars[j].moveForward(false);
            }
        }
    }
}
