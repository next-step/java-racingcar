package study.race;

import java.util.ArrayList;
import java.util.List;

import study.util.RandomNumber;

public class CarRace {

    private List<Car> cars;
    private int tryNum;

    public CarRace(int carNum, int tryNum) {
        cars = initCars(carNum);
        this.tryNum = tryNum;
    }

    private List<Car> initCars(int carNum) {
        List<Car> readyCars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            readyCars.add(new Car());
        }

        return readyCars;
    }
    
    public void run() {
        for (int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                int randomNum = RandomNumber.getRandomNumber();
                car.move(randomNum);
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
