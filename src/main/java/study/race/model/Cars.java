package study.race.model;

import study.race.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<Car>();
    }

    public void addCar(String name) {
        this.carList.add(new Car(name));
    }

    public void moveCarAt(int i) {
        this.carList.get(i).move();
    }

    public int size() {
        return this.carList.size();
    }

    public String getCarNameAt(int i) {
        return this.carList.get(i).getName();
    }

    public Car get(int i) {
        return this.carList.get(i);
    }

    public int getCarDistanceAt(int i) {
        return this.carList.get(i).getLocation();
    }

    public Winners getWinners() {
        return findWinners(findMaxDistance());
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getLocation());
        }
        return maxDistance;
    }

    private Winners findWinners(int maxDistance) {
        Winners winners = new Winners(maxDistance);
        for (Car car : carList) {
            winners.checkAndAddWinner(car.getName(), car.getLocation());
        }
        return winners;
    }
}
