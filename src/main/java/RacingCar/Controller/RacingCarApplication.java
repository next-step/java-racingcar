package RacingCar.Controller;

import RacingCar.Model.*;
import RacingCar.View.InputView;
import RacingCar.View.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carListString = inputView.carNameList();
        int round = inputView.round();

        Racing racing = new Racing(round);
        List<Car> carList = racing.carList(carListString);
        Winner winner = new Winner();
        ResultView resultView = new ResultView();
        RandomNumber randomNumber = new RandomNumber();

        resultView.resultView();

        for (int i = 0; i < racing.getRound(); i++) {
            racing.round(randomNumber, carList);
            resultView.roundView(carList);
        }

        List<Car> winners = winner.winner(carList);

        resultView.winnerView(winners);
    }
}
