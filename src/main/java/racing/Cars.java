package racing;

import java.util.List;

public class Cars {
    public static final int CAN_RUN_MIN_VALUE = 4;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars run(RandomNumberGenerator randomNumGenerator) {
        for(Car car: cars) {
            decideRun(randomNumGenerator, car);
        }
        return new Cars(cars);
    }

    private void decideRun(RandomNumberGenerator randomNumGenerator, Car car) {
        int randomNum = randomNumGenerator.getRandomNum();
        if(randomNum >= CAN_RUN_MIN_VALUE) {
            car.move();
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
