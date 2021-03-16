package carRacing;

import carRacing.model.Car;
import carRacing.util.RandomIntUtil;
import carRacing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars;
    private OutputView outputView;

    public CarRacing(int carCount) {
        checkIntParam(carCount);
        this.cars = new ArrayList<>();
        outputView = new OutputView();
        enrollCars(carCount);
    }

    private void checkIntParam(int param) {
        if(param <= 0)
            throw new IllegalArgumentException("유효한 양의 정수를 입력하세요");

    }

    public void startRacing(int racingCount) {
        checkIntParam(racingCount);
        System.out.println("실행 결과");
        for (int i = 0; i < racingCount; i++) {
            System.out.printf("try : %2d%n", i + 1 );
            excuteCycle();
            outputView.printRacingResultExcutedCycle(cars);
        }
    }

    private void excuteCycle() {
        for (Car car : cars) {
            car.moveByRandomInt(RandomIntUtil.getRandomInt());
        }
    }

    private void enrollCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
