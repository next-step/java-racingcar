package carracing.view;

import carracing.model.Car;
import java.util.List;

public class ResultView {
  private static String RESULT = "실행 결과";
  private static String POSITION_CHARACTER = "_";
  private static String CAR_NAME_FORMAT = "%s : ";

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

      cars.forEach(car -> visualizeCarPosition(car.getName(), car.getPositions().get(presentRound)));
      System.out.println();
    }
  }

  private void visualizeCarPosition(String name, Integer position) {
    System.out.print(String.format(CAR_NAME_FORMAT, name));
    for (int i = 0; i < position; i++) {
      System.out.print(POSITION_CHARACTER);
    }
    System.out.println();
  }
}
