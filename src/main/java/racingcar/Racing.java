package racingcar;

import java.util.*;

public class Racing {

    private final int gameCount;
    private final List<Car> cars;
    private final List<RaceRecord> raceRecord;
    private final RacingRandom racingRandom = RacingRandom.getInstance();

    public Racing(List<String> carNames, int gameCount) {
        this.gameCount = gameCount;
        this.cars = createCars(carNames);
        this.raceRecord = new ArrayList<>();
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> result = new ArrayList<>();
        for (String carName : carNames) {
            result.add(new Car(carName));
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
        raceRecord.add(new RaceRecord(cars));
    }

    private void game() {
        for (Car car : cars) {
            move(car);
        }
    }

    private void move(Car car) {
        if (car.moveable(racingRandom.getNumber())) {
            car.move();
        }
    }

    public List<RaceRecord> getRaceRecord() {
        return raceRecord;
    }

    public List<Car> getWinner(){
        List<Car> winners = new ArrayList<>();
        int max = getHighDistance();
        for (Car car : cars) {
            if(car.getDistance() == max){
                winners.add(car);
            }
        }
        return winners;
    }

    private int getHighDistance() {
        int max = 1;
        for (Car car : cars) {
            if (car.getDistance() > max) {
                max = car.getDistance();
            }
        }
        return max;
    }
}
