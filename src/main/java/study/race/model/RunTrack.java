package study.race.model;

import java.util.Random;

public class RunTrack {

    private Random random;
    private Cars cars;
    private RaceResult raceResult;


    public RunTrack(int numberOfCar) {
        this.random = new Random();
        this.cars = new CarListGenerator().generateCarList(numberOfCar);
        this.raceResult = new RaceResult(this.cars);
    }

    public void start() {
        for (int i = 0; i < this.cars.carList().size(); i++) {
            int movingDistance = random.nextInt(10);
            this.cars.carList().get(i).move(movingDistance);
        }
        this.raceResult.updateRaceResult();
    }

    public int[] getRaceResult() {
        return this.raceResult.getResult();
    }
}
