package controller;

import domain.RacingGame;
import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class RacingGameController {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputView.inputCarNo();
        int carNo = scanner.nextInt();
        InputView.inputTime();
        int time = scanner.nextInt();
        System.out.println("실행 결과");

        RacingGame racingGame = new RacingGame(carNo);
        for (int i = 0; i < time; i++) {
            ResultView.showResult(racingGame.move());
        }

    }
}
