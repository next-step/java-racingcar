package study.step3;

import java.util.ArrayList;
import java.util.List;

import study.step3.model.Car;
import study.step3.model.Movement;
import study.step3.ui.ResultView;

/**
 * Racing Game Class
 *
 * 자동차 경주 클래스
 *
 */
public class Racing {
    private List<Car> carList;
    private Movement movement;
    ResultView resultView;

    public Racing() {
        carList = new ArrayList<>();
        movement = new Movement();
        resultView = new ResultView();
    }

    public void setUp(int carCount) {
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void run() {
        for (Car car : carList) {
            car.move(movement.stopAndMove());
        }
    }

    public void printRacingResult(String printToken) {
        resultView.printRacingResult(carList, printToken);
    }
}
