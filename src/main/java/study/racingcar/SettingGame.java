package study.racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SettingGame {

    private static int ZERO = 0;

    public static boolean isCheckSetGame(int numberOfCars, int countOfGames) {

        return isNegativeNumberAndZero(numberOfCars, countOfGames);
    }

    private static boolean isNegativeNumberAndZero(int inputCars, int inputGames) {

        if(inputCars <= ZERO || inputGames <= ZERO) {
            throw new InputMismatchException("게임 시작을 위한 세팅이 실패 하였습니다.");
        }

        return true;
    }
}
