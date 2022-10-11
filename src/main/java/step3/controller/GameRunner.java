package step3.controller;

import step3.domain.Car;
import step3.domain.Racing;
import step3.domain.RandomStrategy;
import step3.view.EnterGameConfig;
import step3.view.ResultPrinter;

import java.util.List;

public class GameRunner {
    public static void main(String[] args) {
        EnterGameConfig enterGameConfig = new EnterGameConfig();
        String[] carNames = enterGameConfig.enterCarNames();
        int iterate = enterGameConfig.enterIterate();

        Racing racing = new Racing(carNames, iterate, new RandomStrategy());
        racing.start();
        List<Car> cars = racing.getCars();
        List<String> winners = racing.getWinners();

        ResultPrinter resultView = new ResultPrinter(iterate);
        resultView.printRecord(cars);
        resultView.printWinner(winners);
    }
}
