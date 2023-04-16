package racingCar;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveForward;
import racingCar.view.RacingCarGameInputView;
import racingCar.view.RacingCarGameResultView;

public class RacingCarGameApplication {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    final List<String> carNames = RacingCarGameInputView.getCarNames(reader);
    final int moveTryCnt = RacingCarGameInputView.getMoveTryCnt(reader);
    final RacingCarGameResultView resultView = new RacingCarGameResultView();
    final List<RacingCarMoveDirectionStrategy> allowedMoveStrategies = List.of(new RacingCarMoveForward());

    RacingCarGame racingCarGame = new RacingCarGame(carNames, resultView, allowedMoveStrategies);
    racingCarGame.play(moveTryCnt);
    reader.close();
  }
}
