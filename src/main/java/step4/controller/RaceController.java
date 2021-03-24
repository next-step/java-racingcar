package step4.controller;

import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.RandomMovingStrategy;
import step4.domain.Winner;
import step4.dto.Data;
import step4.view.InputView;
import step4.view.ResultView;

public class RaceController {
    InputView inputView;
    ResultView resultView;
    Cars cars;
    Winner winner;

    public RaceController() {
        inputView = new InputView();
        resultView = new ResultView();
        cars = new Cars();
        winner = new Winner();
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
        cars.createList(inputView.getData());
    }

    private void racing() {
        Data data = inputView.getData();
        for (int i = 0; i < data.getCount(); i++) {
            drive();
        }
    }

    private void drive() {
        for (Car car : cars.getCarList()) {
            car.move(new RandomMovingStrategy());
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
