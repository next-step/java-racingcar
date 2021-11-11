package com.kkambi.racing.view;

import com.kkambi.racing.domain.Car;

import java.util.List;

public class TotalView {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public InputView.InputCommand getInput() {
        return inputView.getInput();
    }

    public void printLocation(List<Car> carList) {
        resultView.printLocation(carList);
    }
}
