package racing;

import java.util.List;
import racing.domain.Racing;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarApplication {

  public static void main(String[] args) {
    String carNamesRaw = InputView.getNumberOfCars();
    int roundCount = InputView.getNumberOfRounds();

    Racing racing = new Racing(StringToArray(carNamesRaw));

    System.out.println("실행 결과");

    for (int i = 0; i < roundCount; i++) {
      racing.simulateRace();
      ResultView.printRaceResult(racing.getCars());
    }

    List<String> maxPosition = racing.findWinners();
    System.out.println(String.join(", ", maxPosition) + "가 최종 우승했습니다.");
  }

  private static String[] StringToArray(String carNamesRaw) {
    return carNamesRaw.split(",");
  }
}
