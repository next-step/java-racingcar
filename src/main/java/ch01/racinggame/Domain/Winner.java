package ch01.racinggame.Domain;

import java.util.ArrayList;
import java.util.Collections;

public class Winner {

    ArrayList<Car> winnerCars;
    Car[] cars;

    public Winner(Car[] cars) {
        this.cars = cars;
        winnerCars = new ArrayList<Car>();
    }

    public ArrayList<Car> whoAreWinners() {
        return this.findWinners();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car winnerCar : this.winnerCars) {
            sb.append(winnerCar.name() + ", ");
        }
        return sb.toString().length()>0? sb.substring(0,sb.length()-2):"";
    }


    private void saveWinners(Car car, int winnerProgressCnt) {
        if (car.progressCnt() == winnerProgressCnt) {
            winnerCars.add(car);
        }
    }

    private ArrayList<Car> findWinners() {

        Collections.sort(winnerCars);
        winnerCars.add(cars[0]);
        for (int i = 1; i < cars.length; i++) {
            saveWinners(cars[i], cars[0].progressCnt());
        }
        return winnerCars;

    }
}
