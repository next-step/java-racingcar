package step4.controller;

import step4.domain.*;
import step4.util.RandomUtil;
import step4.view.InputView;
import step4.view.ResultView;

public class RaceController {
    InputView inputView;
    ResultView resultView;
    Cars cars;
    Winner winner;

    public RaceController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.cars = new Cars();
        this.winner = new Winner();
    }

    public void start() {
        inputData();

        createList();

        racing();

        winner();

    }

    private void inputData() {
        inputView.inputData();
    }

    private void createList() {
        cars.createdList(inputView.getData());
    }

    private void racing() {
        Data data = inputView.getData();
        for (int i = 0; i < data.getCount(); i++) {
            drive();
        }
    }

    private void drive() {
        for (Car car : cars.getCarList()) {
            car.move(RandomUtil.getRandomValue());
            renderMove(car);
        }
        System.out.println();
    }

    private void renderMove(Car car) {
        if (car.isMoving()) {
            resultView.render(car);
        }
    }

    private void winner() {
        winner.findWinner(cars);
        resultView.renderWinner(winner.getWinners());
    }

}
