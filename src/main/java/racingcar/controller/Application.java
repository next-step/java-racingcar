package racingcar.controller;

import racingcar.service.RacingCarGame;

import java.util.Scanner;

public class Application {
    public static  void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numTry = scanner.nextInt();
        scanner.close();
        RacingCarGame carGame = new RacingCarGame(carNames, numTry);
        carGame.start();
    };
}
