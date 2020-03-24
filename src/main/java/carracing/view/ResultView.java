package carracing.view;

import carracing.model.Car;
import carracing.model.CarRacing;
import java.util.List;

public class ResultView {
  private static String RESULT = "실행 결과";
  private static String POSITION_CHARACTER = "_";

  private Integer totalRound;
  private List<Car> cars;

  public ResultView(List<Car> cars, Integer totalRound) {
    this.cars = cars;
    this.totalRound = totalRound;
  }

  public void show() {
    System.out.println(RESULT);
    for (int i = 0; i < totalRound; i++) {
      int presentRound = i;

      cars.forEach(car -> visualizePosition(car.getPositions().get(presentRound)));
      System.out.println();
    }
  }

  private void visualizePosition(Integer position) {
    for (int i = 0; i < position; i++) {
      System.out.print(POSITION_CHARACTER);
    }
    System.out.println();
  }
}
