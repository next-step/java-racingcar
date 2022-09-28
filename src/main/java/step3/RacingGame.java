package step3;

import java.util.ArrayList;
import java.util.List;

import static step3.Random.createRandomValue;

public class RacingGame {
    private static final List<Car> cars = new ArrayList<>();
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        setCar(inputView.inputCarCount());
        tryEvent(inputView.inputTryCount());
    }

    public static void setCar(int carCount) {
        for(int i = 0; i < carCount; i++){
            cars.add(new Car());
        }
    }

    public static void tryEvent(int tryCount) {
        resultView.init();
        for (int i = 0; i < tryCount; i++) {
            System.out.println("");
            moveEvent(createRandomValue());
        }
    }

    public static void moveEvent(int randomValue) {
        for (Car car : cars) {
            if (car.isMove(randomValue)) {
                car.setDistance();
            }
            resultView.result(car.getDistance());
        }
    }
}