package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {  //TODO: 일급콜렉션화 시키기

    private List<Car> cars;

    public Cars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for(int i = 0; i < carNames.length; i++) {
            cars.add(createCar(carNames[i]));
        }
        this.cars = cars;
    }

    private Car createCar(String carName) {
        Car car = new Car(carName);
        return car;
    }

    public void clear() {
        this.cars.clear();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int getCarsLength() {
        return cars.size();
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<String>();
        int winnerPosition = getMaxPosition(getFinalPositionList());

        for(Car car: cars) {
            addWinnerName(winnerNames, winnerPosition, car);
        }
        return winnerNames;
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

    private List<String> addWinnerName(List<String> winnerNames, int winnerPosition, Car car) {
        if(isWinner(winnerPosition, car.getPosition())) {
            winnerNames.add(car.getCarName());
        }
        return winnerNames;
    }

    public boolean isWinner(int winnerPosition, int position) {
        if(winnerPosition == position) {
            return true;
        }
        return false;
    }
}
