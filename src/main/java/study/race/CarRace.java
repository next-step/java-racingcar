package study.race;

import java.util.ArrayList;
import java.util.List;

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
    
    public List<Car> getCars() {
        return cars;
    }

    public void run() {

    }

}
