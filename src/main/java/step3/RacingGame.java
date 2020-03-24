package step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private int roundTime;
    private int carCount;
    private String[] carNames;
    private List<Car> cars = new ArrayList<Car>();
    private List<String> winnerNames;

    public RacingGame(int roundTime, String[] carNameList) {
        this.carNames = carNameList;
        this.carCount = carNameList.length;
        this.roundTime = roundTime;
        this.winnerNames = new ArrayList<String>();
    }

    public void start() {
        createCars(carCount, carNames);
        play();
        setWinner();
    }

    public void end() {
        this.cars.clear();
    }

    private void createCars(int carCount, String[] carNameList) {
        for(int i = 0; i < carCount; i++) {
            this.cars.add(createCar(carNameList[i]));
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
        for(Car car: this.cars) {
            moveCar(car, presentRoundTime);
        }
    }

    private void moveCar(Car car, int presentRoundTime) {
        if(GameRule.canMove()) {
            car.move(presentRoundTime);
        }
        car.completeRound(presentRoundTime);
    }

    private void setWinner() {
        List<Integer> finalPositionList = getFinalPositionList();
        int winnerPosition = GameRule.getMaxPosition(finalPositionList);

        for(Car car: cars) {
            addWinnerNames(winnerPosition, car);
        }
    }

    private void addWinnerNames(int winnerPosition, Car car) {
        if(winnerPosition == car.getPosition()) {
            this.winnerNames.add(car.getCarName());
        }
    }

    private List<Integer> getFinalPositionList() {
        List<Integer> finalPositionList = new ArrayList<>();

        for(Car car: cars) {
            finalPositionList.add(car.getPosition());
        }
        return finalPositionList;
    }

    public int getRoundTime() {
        return roundTime;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}


