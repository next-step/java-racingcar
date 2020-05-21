package step5.controller;

import step4.RandomRacingGame;
import step5.Exception.WinnerException;
import step5.domain.*;
import step5.view.*;

import java.util.stream.Stream;

import static step5.view.ResultView.*;

/**
 * 초간단 자동차 경주 게임을 구현한다.
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 */
public class RandomRacingGameController {

  final private MoveStrategy moveStrategy;

  public RandomRacingGameController () {
    this(RandomNumberMoveStrategy.getInstance());
  }

  public RandomRacingGameController (MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public Racing createRacing () {
    String[] cars = InputView.inputCars();
    int time = InputView.inputTime();
    return createRacing(cars, time);
  }

  public Racing createRacing (String[] cars, int time) {
    return Racing.of(Cars.of(cars), time, moveStrategy);
  }

  public Stream<Car> getRaceWinners (Racing racing) throws WinnerException {
    while (!racing.isRaceEnd()) printRace(racing.race());
    return racing.getWinners();
  }

  public void printRacingResult (Racing racing) throws WinnerException {
    printResultText();
    printWinner(getRaceWinners(racing));
  }

  public static void main(String[] args) throws WinnerException {
    RandomRacingGameController controller = new RandomRacingGameController();
    controller.printRacingResult(
      controller.createRacing()
    );
  }

}
