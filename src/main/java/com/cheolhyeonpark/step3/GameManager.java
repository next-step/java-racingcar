package com.cheolhyeonpark.step3;

import java.util.Scanner;

public class GameManager {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        new RacingGame(inputNumberOfCars(scanner), inputNumberOfStages(scanner)).play();
        scanner.close();
    }

    private int inputNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int inputNumberOfStages(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
