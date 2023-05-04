package racinggame;

import racinggame.common.constants.RexFormatConstants;
import racinggame.common.util.RandomUtils;
import racinggame.view.InputView;
import racinggame.view.ResultView;
import racinggame.vo.Car;

import java.util.HashMap;
import java.util.Map;

public class RacingCarGame {

    private static final int MINIMUM_NUMBER_FOR_MOVE = 4;
    private String carsName;
    private int moveNumber;
    private Map<Integer, Car> carMap;

    public void input() {

        carsName = InputView.inputCarsName();
        moveNumber = InputView.inputMoveCount();

    }

    public void start() {

        carMap = createCars(carsName);
        ResultView.resultMessagePrint();
        moveByMoveNumber(moveNumber);
        ResultView.winnerPrint(carMap);

    }

    Map<Integer, Car> createCars(String carsName) {
        String[] cars = carsName.split(RexFormatConstants.CARS_NAME_REX_FORMAT_TEXT.getValue());
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
