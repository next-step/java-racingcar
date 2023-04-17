package racingcar.view;

import racingcar.controller.RacingController;

import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        startRacing();
    }

    private static void startRacing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRaces = scanner.nextInt();

        RacingController.race(numberOfCars, numberOfRaces);
    }
}
