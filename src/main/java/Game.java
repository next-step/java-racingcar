import view.InputView;
import view.ResultView;

import java.util.List;

public class Game {
    private ResultView resultView = new ResultView();
    private InputView inputView = new InputView();
    private Condition condition = new Condition();
    private CarGenerater carGenerater = new CarGenerater();
    private Cars cars = new Cars();

    public void playGame() {
        try {
            inputView.requestEntry();
            String inputEntryCars = inputView.inputStringData();

            inputView.requestTryCount();
            CountTry countTry = new CountTry(inputView.inputIntData());

            playRound(carGenerater.splitEntry(inputEntryCars), countTry.getCountTry());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void playRound(String[] entryCars, int countTry) {
        Cars cars = new Cars();

        List<Car> carsList = cars.makeCars(entryCars);
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