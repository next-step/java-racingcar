package racing.view;

import java.util.List;
import racing.model.RacingCar;

public class ResultView {

  public ResultView() {
    System.out.println("\n실행 결과");
  }

  public void turnResultView(List<RacingCar> movedCarList) {
    for (int i = 0; i < movedCarList.size(); i++) {
      RacingCar racingCar = movedCarList.get(i);
      drawPosition(racingCar);
      System.out.print("\n");
    }
    System.out.print("\n");
  }

  public void drawPosition(RacingCar racingCar) {
    for (int i = 0; i < racingCar.getPosition(); i++) {
      System.out.print("-");
    }
  }
}

