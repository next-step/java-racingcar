package camp.nextstep.racingcar;

import camp.nextstep.racingcar.domain.Car;
import camp.nextstep.racingcar.domain.CarFactory;
import camp.nextstep.racingcar.domain.DefaultMoveCondition;
import camp.nextstep.racingcar.domain.MoveCondition;
import camp.nextstep.racingcar.domain.RacingGame;
import camp.nextstep.racingcar.domain.RandomNumberGenerator;
import camp.nextstep.racingcar.domain.Round;
import camp.nextstep.racingcar.view.InputView;
import camp.nextstep.racingcar.view.ResultView;
import java.util.List;

public class RacingGameApplication {

  public static void main(String[] args) {
    List<Car> cars = CarFactory.of(InputView.getCarNames());
    Round rounds = new Round(InputView.getRounds());
    MoveCondition moveCondition = new DefaultMoveCondition(new RandomNumberGenerator());

    RacingGame racingGame = new RacingGame(cars, rounds);
    while (racingGame.isRacing()) {
      racingGame.race(moveCondition);
      ResultView.print(racingGame.getCars());
    }
    ResultView.printWinner(racingGame.getWinners());
  }
}
