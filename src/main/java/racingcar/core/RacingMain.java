package racingcar.core;

import racingcar.ui.RacingInputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingMain {
    private static final int DEFAULT_FORWARD_CNT = 0;

    public static void main(String[] args) {
        RacingInputView inputView = new RacingInputView(new Scanner(System.in));
        int carCnt = inputView.carCnt();
        int raceTimes = inputView.raceTimes();
        RandomNumber randomNumber = new RandomNumber();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCnt; i++) {
            cars.add(new Car(DEFAULT_FORWARD_CNT, randomNumber.getNumber()));
        }
        RacingCar racingCar = new RacingCar(raceTimes, cars);
        racingCar.start();
    }
}
