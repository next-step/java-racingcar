package racinggame;

import racinggame.common.util.PrintUtils;
import racinggame.common.util.RandomUtils;
import racinggame.common.view.InputView;
import racinggame.common.view.ResultView;
import racinggame.common.vo.Car;

import java.util.HashMap;
import java.util.Map;

public class RacingCarGame implements Game {

    private static Map<Integer, Car> carMap;
    private static final String INPUT_CARS_NAME_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String INPUT_MOVE_NUMBER_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_TEXT = "실행 결과";

    private static final int MINIMUM_NUMBER_FOR_MOVE = 4;

    private static final String CARS_NAME_REX_FORMAT_TEXT = ",";

    private String carsName;
    private int moveNumber;

    @Override
    public void input() {

        PrintUtils.println(INPUT_CARS_NAME_TEXT);
        carsName = InputView.input();
        PrintUtils.println(INPUT_MOVE_NUMBER_TEXT);
        moveNumber = Integer.parseInt(InputView.input());

    }

    @Override
    public void create() {

        carMap = createCars(carsName);

    }

    @Override
    public void start() {

        PrintUtils.println(RESULT_TEXT);
        moveByMoveNumber(moveNumber);

    }

    public static Map<Integer, Car> createCars(String carsName) {
        String[] cars = carsName.split(CARS_NAME_REX_FORMAT_TEXT);
        Map<Integer, Car> createCarMap = new HashMap<>();
        for (int number = 0; number < cars.length; number++) {
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
            carMap.put(car.getNumber(), car);
        }
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
