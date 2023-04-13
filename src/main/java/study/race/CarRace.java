package study.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRace {

    private Random random;

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
                int randomNum = getRandomNumber();
                car.move(randomNum);
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getRandomNumber() {
        if (random == null) {
            random = new Random();
        }
        return random.nextInt(10);
    }

}
