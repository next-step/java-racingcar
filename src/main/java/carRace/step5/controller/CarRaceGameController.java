package carRace.step5.controller;


import carRace.step5.domain.CarRacingGame;
import carRace.step5.domain.util.CarName;
import carRace.step5.domain.util.TryCount;

import java.util.Scanner;

public class CarRaceGameController {

    private static String INPUT_CAR_RACE_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String HOW_MANY_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println(INPUT_CAR_RACE_NAMES);
        String[] carNames = CarName.checkCarNames(scanner.nextLine());
        System.out.println(HOW_MANY_ATTEMPTS);
        int raceTryCount = TryCount.checkNumberValue(scanner.nextLine());

        CarRacingGame carRacingGame = new CarRacingGame(raceTryCount);
        carRacingGame.RunPlayGame(carNames);
    }
}
