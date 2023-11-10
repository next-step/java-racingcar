package study.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunTrack {

    private Random random;
    private List<Car> carList;
    private RaceResult raceResult;


    public RunTrack(int numberOfCar) {
        this.random = new Random();
        this.carList = new CarListGenerator(numberOfCar).generateCarList();
        this.raceResult = new RaceResult(this.carList);
    }

    public void start() {
        for (int i = 0; i < this.carList.size(); i++) {
            int movingDistance = random.nextInt(10);
            this.carList.get(i).move(movingDistance);
        }
        this.raceResult.updateRaceResult();
    }

    public int[] getRaceResult() {
        return this.raceResult.getResult();
    }
}
