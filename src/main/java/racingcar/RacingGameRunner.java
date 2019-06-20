package racingcar;

import racingcar.model.Car;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleResultView;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameRunner {

  public static void main(String[] args) {

    InputView inputView = new ConsoleInputView();
    ResultView resultView = new ConsoleResultView();

    inputView.askQuestions();
    String[] names = inputView.getNames();
    RacingGame racingGame = new RacingGame(names);

    int rounds = inputView.getRounds();
    for (int i = 1; i <= rounds; i++) {
      resultView.printCurrentRound(i);
      List<Car> cars = racingGame.race();
      cars.forEach(resultView::printCurrentPositionOf);
      resultView.addLineBreak();
    }

    String namesOfWinners = racingGame.awards();
    resultView.printWinner(namesOfWinners);

  }
}
