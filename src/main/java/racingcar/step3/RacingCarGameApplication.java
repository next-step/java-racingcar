package racingcar.step3;

import racingcar.step3.domain.Car;
import racingcar.step3.domain.CarFactory;
import racingcar.step3.domain.RacingCarGame;
import racingcar.step3.domain.RacingCarGameFactory;
import racingcar.step3.dto.RacingCarGameResultDto;
import racingcar.step3.ui.InputValue;
import racingcar.step3.ui.InputView;
import racingcar.step3.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameApplication {

  public static void main(String[] args) {
    new RacingCarGameApplication().run(args);
  }

  public void run(String[] args) {
    InputValue input = InputView.receive();
    List<Car> cars = CarFactory.of(input.getNumberOfCars());
    List<RacingCarGame> racingCarGames = RacingCarGameFactory.of(input.getTryCount(), cars);
    List<RacingCarGameResultDto> results = racingCarGames.stream().map(RacingCarGame::start).collect(Collectors.toList());

    ResultView.printResult(results);
  }
}
