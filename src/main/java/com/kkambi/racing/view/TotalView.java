package com.kkambi.racing.view;

import com.kkambi.racing.domain.Racer;

import java.util.List;

public class TotalView {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public InputView.InputCommand getInput() {
        return inputView.getInput();
    }

    public void printLocation(int times, List<Racer> racerList) {
        System.out.printf("%d회 결과%n", times);
        resultView.printLocation(racerList);
    }
}
