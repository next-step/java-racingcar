package study.racingcar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class SettingGame {
    private static int ZERO = 0;

    public static List<Car> createCars(int cars) {

        isNegativeNumberAndZero(cars);

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < cars; i++) {
            carList.add(new Car(ZERO));
        }

        return carList;
    }

    private static void isNegativeNumberAndZero(int number) {

        if(number <= ZERO) {
            throw new InputMismatchException("게임 시작을 위한 세팅이 실패 하였습니다.");
        }
    }
}
