package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameManager {

    final Scanner scanner = new Scanner(System.in);

    public void activate() {
        String[] cars = inputCarNames();
        List<Car> carList = createCars(cars);
        int gameCnt = inputGameTryCnt();
        Game game = new Game(gameCnt, carList);
        game.start();
    }

    private String[] inputCarNames() {
        String[] cars;
        InputValidator inputValidator = new InputValidator();
        do {
            PrintUtils.printInputRequestCarName();
            String carsInput = scanner.nextLine();
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

    private int inputGameTryCnt() {
        String inputCnt;
        InputValidator inputValidator = new InputValidator();
        do {
            PrintUtils.printInputRequestPlayTime();
            inputCnt = scanner.next();
        } while (!inputValidator.validGameCntInput(inputCnt));
        return Integer.parseInt(inputCnt);
    }
}