package racinggame;

import racinggame.common.util.PrintUtils;
import racinggame.common.util.RandomUtils;
import racinggame.view.InputView;
import racinggame.view.ResultView;
import racinggame.vo.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGame implements Game {

    private static final String RESULT_TEXT = "실행 결과";
    private static final int MINIMUM_NUMBER_FOR_MOVE = 4;
    private static final String CARS_NAME_REX_FORMAT_TEXT = ",";

    private String carsName;
    private int moveNumber;
    private Map<Integer, Car> carMap;

    @Override
    public void input() {

        carsName = InputView.inputCarsName();
        moveNumber = InputView.inputMoveCount();

    }

    @Override
    public void start() {

        carMap = createCars(carsName);
        PrintUtils.println(RESULT_TEXT);
        moveByMoveNumber(moveNumber);
        ResultView.winnerPrint(carMap);

    }

    Map<Integer, Car> createCars(String carsName) {
        String[] cars = carsName.split(CARS_NAME_REX_FORMAT_TEXT);
        Map<Integer, Car> createCarMap = new HashMap<>();
        for (int number = 0; number < cars.length; number++) {
            createCarMap.put(number, new Car(number, cars[number]));
        }
        return createCarMap;
    }

    boolean canMove(int randomValue) {
        return randomValue > MINIMUM_NUMBER_FOR_MOVE;
    }

    private void moveByMoveNumber(int moveNumber) {
        for (int i = 0; i < moveNumber; i++) {
            moveByCarNumber();
            ResultView.resultPrint(carMap);
        }
    }

    private void moveByCarNumber() {
        for (Integer carNumber : carMap.keySet()) {
            moveCar(carMap.get(carNumber));
        }
    }

    private void moveCar(Car car) {
        if (canMove(RandomUtils.generate())) {
            car.move();
            carMap.put(car.getNumber(), car);
        }
    }

}
