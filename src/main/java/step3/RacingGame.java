package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int roundTime;
    private int carCount;
    private List<Car> carList = new ArrayList<Car>();
    private GameRule gameRule;

    public RacingGame(int roundTime, int carCount, GameRule gameRule) {
        this.roundTime = roundTime;
        this.carCount = carCount;
        this.gameRule = gameRule;
    }

    public void start() {
        createCars(carCount);
        play();
        end();
    }

    public void end() {
        this.carList.clear();
    }

    private void createCars(int carCount) {
        for(int i = 0; i < carCount; i++) {
            this.carList.add(createCar());
        }
    }

    private Car createCar() {
        Car car = new Car();
        return car;
    }

    public void play() {
        for(int i = 0; i < this.roundTime; i++) {
            moveCars(i);
        }
    }

    private void moveCars(int presentRoundTime) {
        for(Car car: this.carList) {
            if(gameRule.canMove()) {
                car.move(presentRoundTime);
            }
        }
    }

    public int getRoundTime() {
        return roundTime;
    }

    public int getCarCount() {
        return carCount;
    }

    public List<Car> getCarList() {
        return carList;
    }
}


