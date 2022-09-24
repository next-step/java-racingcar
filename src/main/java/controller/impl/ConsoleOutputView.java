package controller.impl;

import controller.OutputView;
import model.GameResult;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printResult(GameResult result) {
        System.out.println();
        result.getCars().stream().forEach(System.out::print);
    }
}
