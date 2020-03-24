package step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private int roundTime;
    private int carCount;
    private String[] carNameList;
    private List<Car> carList = new ArrayList<Car>();
    private List<String> winnerNameList;

    public RacingGame(int roundTime, int carCount) {
        this.carCount = carCount;
        this.roundTime = roundTime;
        this.winnerNameList = new ArrayList<String>();
    }

    public RacingGame(int roundTime, String[] carNameList) {
        this.carNameList = carNameList;
        this.carCount = carNameList.length;
        this.roundTime = roundTime;
        this.winnerNameList = new ArrayList<String>();
    }

    public void start() {
        createCars(carCount, carNameList);
        play();
        getWinner();
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

    private void play() {
        for(int i = 0; i < this.roundTime; i++) {
            moveCars(i);
        }
    }

    private void moveCars(int presentRoundTime) {
        for(Car car: this.carList) {
            moveCar(car, presentRoundTime);
        }
    }

    private void moveCar(Car car, int presentRoundTime) {
        if(GameRule.canMove()) {
            car.move(presentRoundTime);
        }
        car.completeRound(presentRoundTime);
    }

    private void getWinner() {
        List<Integer> finalPositionList = getFinalPositionList();
        int winnerPosition = GameRule.getMaxPosition(finalPositionList);

        for(Car car: carList) {
            makeWinnerNameList(winnerPosition, car);
        }
    }

    private void makeWinnerNameList(int winnerPosition, Car car) {
        if(winnerPosition == car.getPosition()) {
            this.winnerNameList.add(car.getCarName());
        }
    }

    private List<Integer> getFinalPositionList() {
        List<Integer> finalPositionList = new ArrayList<>();

        for(Car car: carList) {
            finalPositionList.add(car.getPosition());
        }
        return finalPositionList;
    }

    public int getRoundTime() {
        return roundTime;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinnerNameList() {
        return winnerNameList;
    }
}


