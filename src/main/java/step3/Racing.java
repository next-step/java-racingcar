package step3;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> carList;
    private final InputDto inputDto;

    public Racing(InputDto inputDto) {
        this.carList = createCar(inputDto.getCarCount());
        this.inputDto = inputDto;
    }

    private List<Car> createCar(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; ++i) {
           cars.add(new Car());
        }
        return cars;
    }

    public void racingCar() {
        start(inputDto.getTryCount());

    }

    private void start(int tryCount) {
        for (int i = 0; i < tryCount; ++i) {
            move();
        }
    }

    private void move() {
        for (int i = 0; i < carList.size(); ++i) {
            Car car = carList.get(i);
            car.carCanGoJudge(RandomNumber.randomNumberGenerator());
            print(car);
        }

        System.out.println();
    }

    private void print(Car car) {
        ResultView.result(car);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
