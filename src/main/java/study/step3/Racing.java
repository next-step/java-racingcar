package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
    private ResultView resultView;

    public Racing() {
        carList = new ArrayList<>();
        movement = new Movement();
        resultView = new ResultView();
    }

    public void setUp(int carCount) {
        IntStream.range(0, carCount).forEach(i -> carList.add(new Car()));
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void run() {
        carList.forEach(car -> car.move(movement.stopAndMove()));
    }

    public void printRacingResult(String printToken) {
        resultView.printRacingResult(carList, printToken);
    }
}
