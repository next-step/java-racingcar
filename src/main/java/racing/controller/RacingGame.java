package racing.controller;

import racing.util.RandomGenerator;
import racing.model.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void start(){
        List<Car> cars = generateCar(InputView.makeQuestion("자동차 대수는 몇 대 인가요?"));
        int count = InputView.makeQuestion("시도할 회수는 몇 회 인가요?");

        showResult(cars, count);
    }

    private void showResult(List<Car> cars, int count) {
        ResultView.printResultTitle();
        for (int i = 0; i < count; i++) {
            printProcess(cars);
            ResultView.printStep();
        }
    }

    private void printProcess(List<Car> cars) {
        for (Car car : cars) {
            CarMoveProcess(car);
            ResultView.print(car);
        }
    }

    private void CarMoveProcess(Car car) {
        if(car.canMove(RandomGenerator.generate())) {
            car.move();
        }
    }

    public List<Car> generateCar(int carCount) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++){
            cars.add(new Car());
        }
        return cars;
    }
}
