package racingcar;

import java.util.*;
import java.util.Random;

public class Racing {

    private final int carsNum;
    private final int gameCount;
    private final List<Car> cars;
    private final List<List<Integer>> raceRecord;

    public Racing(int carsNum, int gameCount) {
        this.carsNum = carsNum;
        this.gameCount = gameCount;
        this.cars = createCars(carsNum);
        this.raceRecord = new ArrayList<>();
    }

    private List<Car> createCars(int carsNum) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < carsNum; i++) {
            result.add(new Car());
        }
        return result;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void race() {
        for (int i = 0; i < gameCount; i++) {
            game();
            record();
        }
    }

    private void record() {
        List<Integer> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.getDistance());
        }
        raceRecord.add(result);
    }

    private void game() {
        for (Car car : cars) {
            car.move(random());
        }
    }

    private int random() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<List<Integer>> getRaceRecord() {
        return raceRecord;
    }

    public void printRaceResult() {
        System.out.println("실행결과");
        if (raceRecord.size() == 0) {
            return;
        }
        for (List<Integer> results : raceRecord) {
            printGame(results);
        }


    }

    private void printGame(List<Integer> results) {
        for (Integer result : results) {
            printDistance(result);
        }
        System.out.println();
    }

    private void printDistance(Integer result) {
        for (int i = 0; i < result; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
