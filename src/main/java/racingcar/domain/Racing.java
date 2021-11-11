package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final List<Car> carList;
    private final int tryCount;
    private final Random random = new Random(System.currentTimeMillis());

    public Racing(int carCount, int tryCount) {
        this.carList = new ArrayList<>(makeCar(carCount));
        this.tryCount = tryCount;
    }

    public Racing(String[] carNames, int tryCount){
        this.carList = new ArrayList<>(makeCar(carNames));
        this.tryCount = tryCount;
    }

    public List<Car> makeCar(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public List<Car> makeCar(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for(String carName: carNames){
            carList.add(new Car(carName));
        }
        return carList;
    }


    public void goingTry(int number) {
        for (Car car : carList) {
            car.increaseState(number);
        }
        OutputView.print(this.result());
    }

    public void goingTry() {
        for (Car car : carList) {
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
        StringBuilder result = new StringBuilder();
        for (Car car : carList) {
            result.append(car.print()).append("\n");
        }
        return result.toString();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
