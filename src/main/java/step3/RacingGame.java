package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int roundTime;
    private int carCount;
    private String[] carNameList;
    private List<Car> carList = new ArrayList<Car>();
    private GameRule gameRule;

    public RacingGame(int roundTime, GameRule gameRule, int carCount) {
        this.carCount = carCount;
        this.roundTime = roundTime;
        this.gameRule = gameRule;
    }

    public RacingGame(int roundTime, GameRule gameRule, String[] carNameList) {
        this.carNameList = carNameList;
        this.carCount = carNameList.length;
        this.roundTime = roundTime;
        this.gameRule = gameRule;
    }

    public void start() {
        createCars(carCount, carNameList);
        play();
    }

    public void end() {
        this.carList.clear();
    }

    private void createCars(int carCount, String[] carNameList) {
        for(int i = 0; i < carCount; i++) {
            this.carList.add(createCar(carNameList[i]));
        }
    }

    private Car createCar(String carName) {
        Car car = new Car(carName);
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
            car.completeRound(presentRoundTime);
        }
    }

    public List<Car> getWinner() {
        return gameRule.getWinner(carList);
    }

    public int getRoundTime() {
        return roundTime;
    }

    public List<Car> getCarList() {
        return carList;
    }
}


