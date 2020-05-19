package step4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 초간단 자동차 경주 게임을 구현한다.
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 */
public class Racing {
  private final MoveStrategy moveStrategy;
  private final Cars cars;
  private Iterator<Integer> time;

  private Racing(final Cars cars, final int time, final MoveStrategy moveStrategy) {
    validateTime(time);
    this.moveStrategy = moveStrategy;
    this.time = Arrays.stream(new int[time]).boxed().iterator();
    this.cars = cars;
  }

  public Stream<Car> race () {
    if (time.hasNext()) {
      time.next();
      return cars.move(moveStrategy).stream();
    }
    return null;
  }

  public boolean isRaceEnd () {
    return !time.hasNext();
  }

  public String getWinners () throws WinnerException {
    validateWinner();
    int winnerPosition = this.cars.stream()
                                  .map(v -> v.getPosition())
                                  .max(Integer::compare)
                                  .get();
    return this.cars.stream()
                    .filter(v -> v.getPosition() == winnerPosition)
                    .map(v -> v.getName())
                    .collect(Collectors.joining(", "));
  }

  public void validateTime (int time) {
    if (time < 1) throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
  }

  public void validateWinner () throws WinnerException {
    if (time.hasNext()) throw new WinnerException();
  }

  public static Racing of(final Cars cars, final int time, final MoveStrategy moveStrategy) {
    return new Racing(cars, time, moveStrategy);
  }

}
