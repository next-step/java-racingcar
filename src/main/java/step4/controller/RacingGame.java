package step4.controller;

import step4.domain.Cars;
import step4.domain.RandomRacingStrategy;
import step4.domain.Simulator;
import step4.view.InputView;
import step4.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;

public class RacingGame {

    private RacingGame() {

    }

    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(System.out, true);
        InputView inputView = new InputView(new Scanner(System.in), output);
        ResultView resultView = new ResultView(output);
        Cars cars = Cars.ofNames(inputView.getCarNames());
        Simulator simulator = new Simulator(inputView.getTryCountFromInput(), cars);

        simulator.execute(new RandomRacingStrategy());
        resultView.show(cars.getRecords());
        resultView.showWinner(cars.getWinnerRecord());
        output.close();
    }

}
