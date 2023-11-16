package study.race.model;

import java.util.Random;

public class RunTrack {

    private  final int RANDOM_LIMIT_NUMBER = 10;
    private Random random;
    private Cars cars;
    private RaceResult raceResult;


    public RunTrack(String[] namesOfCar) {
        this.random = new Random();
        this.cars = new CarListGenerator().generateCarList(namesOfCar);
        this.raceResult = new RaceResult(this.cars);
    }

    public void start() {
        for (int i = 0; i < this.cars.carList().size(); i++) {
            int movingDistance = random.nextInt(RANDOM_LIMIT_NUMBER);
            this.cars.carList().get(i).move(movingDistance);
        }
        this.raceResult.updateRaceResult();
    }

    public RaceResult getRaceResult() {
        return this.raceResult;
    }
}
