package racing;

import racing.domain.Cars;
import racing.domain.TryNumber;
import racing.domain.Winners;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {

  public static void main(String[] args) {
    OutputView.carsName();
    Cars cars = new Cars(InputView.getStringValue());

    OutputView.tryNumber();
    TryNumber tryNumber = new TryNumber(InputView.getIntValue());

    OutputView.resultText();
    for (int i = 0; i < tryNumber.getTryNumber(); i++) {
      OutputView.moveDistance(cars.tryMove());
      OutputView.println();
    }

    Winners winners = cars.findWinner();
    OutputView.winner(winners.getWinnersName());
  }

}
