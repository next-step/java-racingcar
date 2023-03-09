package car.controller;

import car.service.RacingGameService;

import java.util.Scanner;

public class RacingGameController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("경주에 참가할 자동차의 이름들을 작성하세요: ");
        String carNames = sc.nextLine();
        System.out.print("이동할 횟수를 입력하세요: ");
        int moveCount = sc.nextInt();

        RacingGameService gameService = new RacingGameService();
        gameService.start(carNames, moveCount);
    }
}
