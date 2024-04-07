package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingController {
    private ResultView resultView = new ResultView();
    private InputView inputView = new InputView();
    private Condition condition = new Condition();
    private CarGenerater carGenerater = new CarGenerater();

    public void playRacing() {
        inputView.requestEntry();
        String inputEntryCars = inputView.inputStringData();

        Cars cars = new Cars(carGenerater.splitEntry(inputEntryCars));

        try {
            cars.validateCar(cars.getCars());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        try {
            inputView.requestTryCount();
            CountTry countTry = new CountTry(inputView.inputIntData());

            playRound(cars.getCars(), countTry.getCountTry(), cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void playRound(List<Car> carsList, int countTry, Cars cars) {
        resultView.printResult();

        for (int i = 0; i < countTry; i++) {
            playMove(carsList);
        }

        resultView.printWinner(cars.judgeWinner(carsList));
    }

    private void playMove(List<Car> carsList) {
        for (int i = 0; i < carsList.size(); i++) {
            carsList.get(i).move(condition.checkCondition());
            resultView.printCarName(carsList.get(i).getCarName());
            resultView.printCarMoving(resultStr(carsList.get(i)));
        }
        resultView.printSeperateCar();
    }

    private String resultStr(Car car) {
        String result = "";
        for (int i = 0; i < car.getPosition(); i++) {
            result += resultView.printMovingPattern();
        }
        return result;
    }
}