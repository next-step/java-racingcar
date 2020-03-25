package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {  //TODO: 일급콜렉션화 시키기

    private List<Car> cars;
    private List<String> winnerNames; //TODO:  중복 인스턴스 변수. 필요한 시점에만 구하면 되므로 삭제 대상

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

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int getCarsLength() {
        return cars.size();
    }

    public List<String> getWinnerNames() {
        return this.winnerNames;
    }

    public void setWinnerNames() {
        int winnerPosition = getMaxPosition(getFinalPositionList());

        for(Car car: cars) {
            addWinnerName(winnerPosition, car);
        }
        this.winnerNames = winnerNames;
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

    private void addWinnerName(int winnerPosition, Car car) {
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
