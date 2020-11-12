package carRace.step5.client;


import carRace.step5.domain.util.CarDataCheck;
import carRace.step5.controller.CarRaceGameController;

import java.util.Scanner;

public class ClientRasingGame {

    private static String INPUT_CAR_RACE_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String HOW_MANY_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);
    private static CarRaceGameController carRaceGameStart = new CarRaceGameController();


    public static void main(String[] args) {
        System.out.println(INPUT_CAR_RACE_NAMES);
        String[] carNames = CarDataCheck.checkName(scanner.nextLine());
        System.out.println(HOW_MANY_ATTEMPTS);
        int raceTryCount = CarDataCheck.checkTryCount(scanner.nextLine());

        carRaceGameStart.gameStart(carNames, raceTryCount);

    }

}
