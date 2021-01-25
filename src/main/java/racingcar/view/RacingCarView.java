package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;
import racingcar.util.PrintUtils;
import racingcar.util.ValidateUtils;

public class RacingCarView {

    final Scanner scanner = new Scanner(System.in);

    public List<Car> createCars(String[] cars) {
        List<Car> carList = new ArrayList<>();
        Arrays
            .stream(cars)
            .forEach(car -> carList.add(new Car(car)));
        return carList;
    }

    public String[] inputCarNames() {
        String[] cars;
        ValidateUtils validateUtils = new ValidateUtils();
        do {
            PrintUtils.printInputRequestCarName();
            String carsInput = scanner.nextLine();
            cars = carsInput.split(",");
        } while (!validateUtils.validateCarName(cars));
        return cars;
    }

    public int inputGameTryCnt() {
        String inputCnt;
        ValidateUtils validateUtils = new ValidateUtils();
        do {
            PrintUtils.printInputRequestPlayTime();
            inputCnt = scanner.next();
        } while (!validateUtils.validGameCntInput(inputCnt));
        return Integer.parseInt(inputCnt);
    }
}
