package step3.common;

import step3.common.util.PrintUtils;
import step3.common.util.RandomUtils;
import step3.common.view.InputView;
import step3.common.view.ResultView;
import step3.common.vo.Car;

import java.util.HashMap;
import java.util.Map;

public class RacingCarGame implements Game {

    private static int carNumber;
    private static int moveNumber;

    private static Map<Integer, Car> carMap;
    private static final String INPUT_CAR_NUMBER_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_MOVE_NUMBER_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_TEXT = "실행 결과";

    private static final int MINIMUM_NUMBER_FOR_MOVE = 4;


    @Override
    public void start() {

        PrintUtils.println(INPUT_CAR_NUMBER_TEXT);
        carNumber = InputView.input();
        PrintUtils.println(INPUT_MOVE_NUMBER_TEXT);
        moveNumber = InputView.input();
        carMap = createCars(carNumber);
        PrintUtils.println(RESULT_TEXT);
        moveByMoveNumber(moveNumber);

    }

    public static Map<Integer, Car> createCars(int carNumber) {
        Map<Integer, Car> createCarMap = new HashMap<>();
        for (int number = 0; number < carNumber; number++) {
            createCarMap.put(number, new Car(number));
        }
        return createCarMap;
    }

    public static boolean canMove(int randomValue) {
        return randomValue > MINIMUM_NUMBER_FOR_MOVE;
    }

    public void moveCar(Car car) {
        if (canMove(RandomUtils.generate())) {
            car.move();
        }
        carMap.put(car.getNumber(), car);
    }

    public void moveByCarNumber() {
        for (Integer carNumber : carMap.keySet()) {
            moveCar(carMap.get(carNumber));
        }
    }

    public void moveByMoveNumber(int moveNumber) {
        for (int i = 0; i < moveNumber; i++) {
            moveByCarNumber();
            ResultView.resultPrint(carMap);
        }
    }

}
