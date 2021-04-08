package racingcar.view.result;

import java.util.List;
import racingcar.domain.car.CarStatusDTO;
import racingcar.domain.racing.Racing;

public class ResultView {

  private final Racing racing;
  private final static String POSITION_UNIT = "-";

  public ResultView(Racing racing) {
    this.racing = racing;
  }

  public void printPreRacing() {
    System.out.println();
    System.out.println("실행 결과");
  }

  public void printNow() {
    this.racing.currentSituation()
        .stream()
        .map(this::generateCurrentSituation)
        .forEach(System.out::println);
    System.out.println();
  }

  public void printWinner() {
    List<String> winnerCarName = racing.getWinnerCarName();
    String winnerJoinList = String.join(", ", winnerCarName);
    System.out.println(winnerJoinList + "가 최종 우승했습니다.");
  }

  private String generateCurrentSituation(CarStatusDTO carStatusDTO) {
    String carName = carStatusDTO.getCarName();
    int currentPosition = carStatusDTO.getCurrentPosition();
    StringBuilder builder = new StringBuilder()
        .append(carName)
        .append(" : ");
    for (int i = 0; i < currentPosition; ++i) {
      builder.append(POSITION_UNIT);
    }
    return builder.toString();
  }
}
