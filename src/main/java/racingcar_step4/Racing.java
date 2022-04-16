package racingcar_step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private InputValue iv;
    private List<Car> cars = new ArrayList<>();

    public Racing() {
        //자동차이름과 시도횟수 입력받는 책임을 InputView클래스에게 위임
        iv = InputView.input();
        for (String name : iv.getCarsArray()) {
            cars.add(new Car(name));
        }

    }

    public static void main(String[] args) {
        new Racing().start();
    }

    public void start(){
        moveAllTime();
        showResult();
        showWinner();
    }

    private void moveAllTime() {
        //주어진 횟수동안
        for (int tryCnt = 0; tryCnt < iv.getTryNum(); tryCnt++) {
            moveEachCar();
        }
    }

    private void moveEachCar() {
        //전진 또는 멈춤 시키기 Car객체에게
        for (Car car : cars) {
            car.move(getRandom());
        }
    }

    private int getRandom() {
        return new Random().nextInt(10);
    }

    private void showResult() {
        ResultView.showAllStates(cars, iv.getTryNum());
    }

    private void showWinner() {
        ResultView.showWinner(cars);
    }


}
