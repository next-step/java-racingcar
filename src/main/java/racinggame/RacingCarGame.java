package racinggame;

import racinggame.domain.Car;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class RacingCarGame {

    private String[] cars;
    private int moveNumber;
    private Map<Integer, Car> carMap;

    public void input() {

        cars = InputView.inputCarsName();
        moveNumber = InputView.inputMoveCount();

    }

    public void start() {

        carMap = createCars(cars);
        ResultView.resultMessagePrint();
        moveByMoveNumber(moveNumber);
        ResultView.winnerPrint(carMap);

    }

    Map<Integer, Car> createCars(String[] cars) {
        Map<Integer, Car> createCarMap = new HashMap<>();
        for (int number = 0; number < cars.length; number++) {
            createCarMap.put(number, new Car(number, cars[number]));
        }
        return createCarMap;
    }

    private void moveByMoveNumber(int moveNumber) {
        for (int i = 0; i < moveNumber; i++) {
            moveByCarNumber();
            ResultView.resultPrint(carMap);
        }
    }

    private void moveByCarNumber() {
        for (Integer carNumber : carMap.keySet()) {
            Car car = carMap.get(carNumber);
            car.move();
            carMap.put(car.getNumber(), car);
        }
    }

}
