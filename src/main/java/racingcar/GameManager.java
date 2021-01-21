package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    public void activate(Scanner scanner) {
        String[] cars = inputCarNames(scanner);
        List<Car> carList = createCars(cars);
        int gameCnt = inputGameTryCnt(scanner);

        Game game = new Game(gameCnt, carList);
        game.start();
    }

    private String[] inputCarNames(Scanner scanner) {
        String[] cars;
        InputValidator inputValidator = new InputValidator();
        do {
            System.out.println(Constant.INPUT_REQUEST_CAR_NAME);
            String carsInput = scanner.next();
            cars = carsInput.split(",");
        } while (!inputValidator.validateCarName(cars));
        return cars;
    }

    private static List<Car> createCars(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }

    private int inputGameTryCnt(Scanner scanner) {
        String inputCnt;
        InputValidator inputValidator = new InputValidator();
        do {
            System.out.println(Constant.INPUT_REQUEST_PLAY_TIME);
            inputCnt = scanner.next();
        } while (!inputValidator.validGameCntInput(inputCnt));
        return Integer.parseInt(inputCnt);
    }
}