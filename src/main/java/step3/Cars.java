package step3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;
    private List<String> winnerNames;

    public Cars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for(int i = 0; i < carNames.length; i++) {
            cars.add(createCar(carNames[i]));
        }
        this.cars = cars;

        winnerNames = new ArrayList<String>();
    }

    private Car createCar(String carName) {
        Car car = new Car(carName);
        return car;
    }

    public void clear() {
        this.cars.clear();
        this.winnerNames.clear();
    }

    public int getCarsLength() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public List<Integer> getFinalPositionList() {
        List<Integer> finalPositionList = new ArrayList<>();

        for(Car car: cars) {
            finalPositionList.add(car.getPosition());
        }
        return finalPositionList;
    }

    public static int getMaxPosition(List<Integer> finalPositions) {
        return Collections.max(finalPositions);
    }

    public List<String> getWinner() {
        List<String> winnerNames = new ArrayList<String>();
        int winnerPosition = getMaxPosition(getFinalPositionList());

        for(Car car: cars) {
            addWinnerName(winnerPosition, car);
        }
        return winnerNames;
    }

    public void addWinnerName(int winnerPosition, Car car) {
        if(isWinner(winnerPosition, car)) {
            winnerNames.add(car.getCarName());
        }
    }

    public boolean isWinner(int winnerPosition, Car car) {
        if(winnerPosition == car.getPosition()) {
            return true;
        }
        return false;
    }



}
