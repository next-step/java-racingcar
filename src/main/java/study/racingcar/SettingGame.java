package study.racingcar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class SettingGame {

    private static String CAR_START_POSITION = "";
    private static int ZERO = 0;
    public static boolean isReadyToGame(int numberOfCars, int countOfGames) {

        return isNegativeNumberAndZero(numberOfCars, countOfGames);
    }

    private static boolean isNegativeNumberAndZero(int inputCars, int inputGames) {

        if(inputCars <= ZERO || inputGames <= ZERO) {
            throw new InputMismatchException("게임 시작을 위한 세팅이 실패 하였습니다.");
        }

        return true;
    }

    public static List<Car> createCars(int cars) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < cars; i++) {
            carList.add(new Car(CAR_START_POSITION));
        }

        return carList;
    }
}
