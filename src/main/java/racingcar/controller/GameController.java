package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.util.Constant;
import racingcar.domain.Car;
import racingcar.util.InputValidator;

public class GameController {

    public void activate(Scanner scanner) {
        String[] cars = inputCarNames(scanner);
        List<Car> carList = createCars(cars);
        int gameCnt = inputGameTryCnt(scanner);

        Game game = new Game(gameCnt, carList);
        game.start();
    }

    private String[] inputCarNames(Scanner scanner) {
        String[] cars;
        do {
            System.out.println(Constant.INPUT_REQUEST_CAR_NAME);
            String carsInput = scanner.next();
            cars = carsInput.split(",");
        } while (!InputValidator.validateCarName(cars));
        return cars;
    }

    private static List<Car> createCars(String[] cars) {
        List<Car> carList = new ArrayList<>();
        Arrays.stream(cars).forEach(car -> carList.add(new Car(car)));
        return carList;
    }

    private int inputGameTryCnt(Scanner scanner) {
        String inputCnt;
        do {
            System.out.println(Constant.INPUT_REQUEST_PLAY_TIME);
            inputCnt = scanner.next();
        } while (!InputValidator.validGameCntInput(inputCnt));
        return Integer.parseInt(inputCnt);
    }
}