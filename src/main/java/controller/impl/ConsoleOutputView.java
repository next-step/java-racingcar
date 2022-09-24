package controller.impl;

import controller.OutputView;
import model.Car;
import model.GameResult;

public class ConsoleOutputView implements OutputView {

    private static final String DEFAULT_CONCAT_STRING = ",";

    @Override
    public void printResult(GameResult result) {
        System.out.println();
        result.getCars().stream().forEach(System.out::print);

    }
    @Override
    public void printWinner(GameResult result){
        String winnerNames = result.getCars().stream().map(Car::getName).reduce((x,y)->x+ DEFAULT_CONCAT_STRING +y).orElse("");
        System.out.println(winnerNames + WINNER_MSG);
    }
}
