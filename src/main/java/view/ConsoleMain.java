package view;

import domain.CarResult;
import domain.RacingGame;

import java.util.Scanner;

public class ConsoleMain {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView(sc);
        RacingGame racingGame = new RacingGame(inputView.getRacingCars().split(","), inputView.getTryCnt());
        ResultView.watchRace(racingGame);
        CarResult.getRaceWinners(racingGame.getCars());
    }
}
