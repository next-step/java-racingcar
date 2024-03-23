import view.InputView;
import view.ResultView;

import java.util.List;

public class Game {
    private ResultView resultView = new ResultView();
    private InputView inputView = new InputView();
    private Input input = new Input();
    private RandomMaker randomMaker = new RandomMaker();

    public void playGame() {
        try {
            inputView.requestEntry();
            int countCar = input.inputIntData();

            inputView.requestTryCount();
            int countTry = input.inputIntData();

            playRound(countCar, countTry);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void playRound(int countCar, int countTry) {
        Cars cars = new Cars();

        List<Car> carsList = cars.makeCars(countCar);
        resultView.printResult();

        for (int i = 0; i < countTry; i++) {
            playMove(carsList);
        }
    }

    private void playMove(List<Car> carsList) {
        for (int i = 0; i < carsList.size(); i++) {
            carsList.get(i).moveOnCondition(randomMaker.generateRandom());
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