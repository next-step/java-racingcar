package step3.controller;

import step3.model.Car;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.Random;

public class CarRacingController {
    Random random = new Random();
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    private final int MAX_BOUND = 10;
    private final int MOVE_STANDARD = 4;

    // 난수 생성
    public int randomNumberGenerator(){
        return random.nextInt(MAX_BOUND);
    }

    // 차 움직임 판별
    public void moveCar(int num, Car car) {
        if (num >= MOVE_STANDARD) {
            car.move();
        }
    }

    // 레이싱 게임
    public void racing() {
        int numberOfCars = inputView.askNumberOfCars();
        int numberOfTrys = inputView.askNumberOfTrys();

        ArrayList<Car> list = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            list.add(new Car());
        }

        for (int i = 0; i < numberOfTrys; i++) {
            for (Car car : list) {
                moveCar(randomNumberGenerator(), car);
            }
            resultView.drawResult(list);
        }
    }
}
