package racingcar.controller;

import racingcar.model.RacingGame;

import java.util.Scanner;

public class RacingGameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();

        RacingGame game = new RacingGame(numberOfCars);
        game.startGame(count);
    }
}