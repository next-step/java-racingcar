package RacingCar;

import java.util.List;
import java.util.Random;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carListString = inputView.carNameList();
        int round = inputView.round();

        Validate.emptyCheck(carListString);

        Racing racing = new Racing(carListString, round);
        ResultView resultView = new ResultView();
        RandomNumber randomNumber = new RandomNumber();

        resultView.resultView();
        List<Car> carList = racing.getCarList();
        for (int i = 0; i < racing.getRound(); i++) {
            racing.round(randomNumber.randomList(carList.size()));
            resultView.roundView(carList);
        }

        List<Car> winners = racing.winner();

        resultView.winnerView(winners);
    }
}
