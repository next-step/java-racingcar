package racingcar;

import racingcar.controller.ConsoleController;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String numberOfCars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String numberOfAttempts = scanner.nextLine();

        ConsoleController consoleController = new ConsoleController();
        consoleController.consoleRacingGameStart(numberOfCars, numberOfAttempts);
    }
}
