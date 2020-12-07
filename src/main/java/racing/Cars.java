package racing;

import java.util.List;

public class Cars {
    private static final int CAN_RUN_MIN_VALUE = 4;
    private List<Car> cars;

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars run(RandomNumberGenerator randomNumGenerator) {
        for(Car car: cars) {
            decideRun(randomNumGenerator, car);
        }
        return this;
    }

    private void decideRun(RandomNumberGenerator randomNumGenerator, Car car) {
        int randomNum = randomNumGenerator.getRandomNum();
        if(randomNum >= CAN_RUN_MIN_VALUE) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars generate(int number) {
        for(int i = 0; i < number; i ++){
            cars.add(new Car());
        }
        return this;
    }
}
