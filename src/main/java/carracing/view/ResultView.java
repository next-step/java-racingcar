package carracing.view;

import carracing.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
  private static String CAR_NAME_FORMAT = "%s : ";
  private static String POSITION_CHARACTER = "_";
  private static String RESULT = "실행 결과";
  private static String WINNER_DELIMETER = ", ";
  private static String WINNER_FORMAT = "%s가 최종 우승했습니다.";

  private Integer totalRound;
  private List<Car> cars;

  public ResultView(List<Car> cars, Integer totalRound) {
    this.cars = cars;
    this.totalRound = totalRound;
  }

  public void show() {
    System.out.println();
    System.out.println(RESULT);
    for (int i = 0; i <= totalRound; i++) {
      int presentRound = i;

      cars.forEach(car -> visualizeCarPosition(car.getName(), car.getPositions().get(presentRound)));
      System.out.println();
    }
    announceTheWinner();
  }

  private void visualizeCarPosition(String name, Integer position) {
    System.out.print(String.format(CAR_NAME_FORMAT, name));
    for (int i = 0; i < position; i++) {
      System.out.print(POSITION_CHARACTER);
    }
    System.out.println();
  }

  private void announceTheWinner() {
    int distance = 0;
    for (Car car : cars) {
      distance = Math.max(distance, car.getFinalPosition());
    }

    int winnerDistance = distance;
    List<String> winners = cars.stream()
        .filter(car -> car.getFinalPosition() == winnerDistance)
        .map(Car::getName)
        .collect(Collectors.toList());

    System.out.printf(WINNER_FORMAT, String.join(WINNER_DELIMETER, winners));
  }
}
