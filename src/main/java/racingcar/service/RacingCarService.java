package racingcar.service;

import java.util.Random;
import java.util.Scanner;

public class RacingCarService {
    private final Scanner scanner = new Scanner(System.in);

    public int EnterNumberOfCars() {
        return scanner.nextInt();
    }

    public int EnterNumberOfMoves() {
        return scanner.nextInt();
    }

    public int[] generateRandomNumberForMovingCar(int numberOfCars) {
        Random random = new Random();

        int[] randomNumbers = new int[numberOfCars];

        // 입력받은 자동차 대수 만큼 랜덤한 값을 발생시킴
        for(int i = 0; i < numberOfCars; i++)
            randomNumbers[i] = random.nextInt(9) + 1; // 1부터 9까지의 랜덤한 숫자 발생

        return  randomNumbers;
    }
}
