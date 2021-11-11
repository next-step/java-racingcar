package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final List<Car> cars;
    private final int tryCount;
    private final Random random = new Random(System.currentTimeMillis());

    public Racing(int carCount, int tryCount) {
        this.cars = new ArrayList<>(makeCar(carCount));
        this.tryCount = tryCount;
    }

    public Racing(String[] carNames, int tryCount){
        this.cars = new ArrayList<>(makeCar(carNames));
        this.tryCount = tryCount;
    }

    public List<Car> makeCar(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> makeCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for(String carName: carNames){
            cars.add(new Car(carName));
        }
        return cars;
    }


    public void goingTry(int number) {
        for (Car car : cars) {
            car.increaseState(number);
        }
        OutputView.print(this.result());
    }

    public void goingTry() {
        for (Car car : cars) {
            car.increaseState(random.nextInt(10));
        }
        OutputView.print(this.result());
    }

    public void start() {
        OutputView.print("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            this.goingTry();
        }
    }

    public String result() {
        return OutputView.print(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
