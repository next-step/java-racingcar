package step3;

import step3.domain.Cars;
import step3.domain.Simulator;
import step3.view.InputView;
import step3.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;

public class RacingGame {

    private RacingGame() {

    }

    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(System.out, true);
        InputView inputView = new InputView(new Scanner(System.in), output);
        ResultView resultView = new ResultView(output);
        Cars cars = Cars.of(inputView.getCarCountFromInput());
        Simulator simulator = new Simulator(inputView.getTryCountFromInput(), cars);

        simulator.execute();
        resultView.show(cars.getRecords());
        output.close();
    }

}
