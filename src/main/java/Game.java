import view.InputView;
import view.ResultView;

import java.util.List;

public class Game {
    private ResultView resultView = new ResultView();
    private InputView inputView = new InputView();
    private Input input = new Input();
    private RandomMaker randomMaker = new RandomMaker();
    private Entry entry = new Entry();

    public void playGame() {
        try {
            inputView.requestEntry();
            String inputEntryCars = input.inputStringData();

            inputView.requestTryCount();
            CountTry countTry = new CountTry(input.inputIntData());

            playRound(entry.splitEntry(inputEntryCars), countTry.getCountTry());

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

        resultView.printWinner(isWinning(carsList));
    }

    private void playMove(List<Car> carsList) {
        for (int i = 0; i < carsList.size(); i++) {
            carsList.get(i).moveOnCondition(randomMaker.generateRandom());
            resultView.printCarName(carsList.get(i).getName());
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

    private String isWinning(List<Car> carsList){
        int maxPosition = carsList.get(0).getPosition();
        String winner = carsList.get(0).getName();

        for (int i = 1; i < carsList.size(); i++) {
           int compareNum = carsList.get(i).getPosition();
            if (maxPosition < compareNum) {
                maxPosition = compareNum;
                winner = carsList.get(i).getName();
            }

            if (maxPosition == compareNum){
                winner += ", " + carsList.get(i).getName();
            }
        }
        return winner;
    }
}