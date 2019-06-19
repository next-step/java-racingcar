package racingcar.view;

import racingcar.model.Car;
import racingcar.util.refree.Referee;

import javax.xml.transform.Result;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * 화면에 Racing 관련 정보들을 출력하는 클래스
 */
public class ConsoleResultView implements ResultView {

  private static final String CURRENT_POSITION_MARKER = "-";

  /**
   * 현재 라운드를 화면에 출력
   * @param round
   */
  public void printCurrentRound(int round) {
    String resultMessage = round + "번째 라운드";
    System.out.println(resultMessage);
  }

  /**
   * 현재 라운드와 다음 라운드 사이에 공백을 추가하여 가독성 up
   */
  public void addLineBreak() {
    System.out.println();
    System.out.println();
  }

  /**
   * Car의 현재 position을 MARKER을 사용하여 표시
   * ex) ----
   * @param car
   */
  public void printCurrentPositionOf(Car car) {

    String nameOfCar = car.getName();
    String currentPosition = IntStream.rangeClosed(car.getInitialPosition(), car.getPosition())
            .mapToObj(pos -> CURRENT_POSITION_MARKER)
            .collect(joining());

    String resultMessage = nameOfCar.concat(" : ").concat(currentPosition);
    System.out.println(resultMessage);
  }

  public void printWinner(List<Car> cars) {
    String resultMessage = Referee.getWinnerFrom(cars).concat("가 최종 우승했습니다.");
    System.out.println(resultMessage);
  }
}
