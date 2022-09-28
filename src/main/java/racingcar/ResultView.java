package racingcar;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

  public void printResult(int tryTimes, List<Car> cars) {
    System.out.println("실행 결과");
    RacingRule racingRule = new RacingRule();
    racingRule.cycleTryTimes(tryTimes, cars);
  }

}
