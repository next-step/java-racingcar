package carRacingWinner.controller;

import carRacingWinner.service.WinnerService;

import java.util.Scanner;

public class WinnerRacingController {


    private final WinnerService winnerService;

    public WinnerRacingController(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    public void racingStart() {
        carsNameInput();
        tryCount();
    }

    public void carsNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        winnerService.makeCars(input());
    }

    private void tryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        input();
    }

    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
