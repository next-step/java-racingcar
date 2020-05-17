package step3;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.Arrays;

/**
 * 초간단 자동차 경주 게임을 구현한다.
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 */
public class Racing {
  private final ResultView RESULT_VIEW;
  private final Cars CARS;
  private final int TIME;

  public Racing(final ResultView resultView, final InputView inputView) {
    this.RESULT_VIEW = resultView;
    this.CARS = Cars.of(inputView.inputCars(), RandomNumberMoveStrategy.of());
    this.TIME = inputView.inputTime();
    validateTime();
  }

  public void race () {
    RESULT_VIEW.printResultText();
    Arrays.stream(new int[TIME])
          .forEach(v -> RESULT_VIEW.printRace(CARS.move()));
  }

  public static Racing of (final ResultView resultView, final InputView inputView) {
    return new Racing(resultView, inputView);
  }

  public void validateTime () {
    if (TIME < 1) throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
  }
}
