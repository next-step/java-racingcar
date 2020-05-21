package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class ResultView {

  private Game game;
  private List<String> resultList = new ArrayList<>();

  private ResultView(Game game) {
    this.game = game;
  }

  public ResultView printView() {
    for (int carSizeIndex = 0; carSizeIndex < game.getCars().size(); carSizeIndex++) {
      String currentView = makeView(carSizeIndex);
      resultList.add(currentView);
      System.out.println(game.getCars().get(carSizeIndex).getName() + " " + currentView);
    }
    winnerView(this.game.getCars()).forEach(element -> System.out.println("우승자: " + element.getName()));
    return this;
  }

  private String makeView(int carSizeIndex) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int positionIndex = 0; positionIndex < game.getCars().get(carSizeIndex).getPosition();
        positionIndex++) {
      stringBuilder.append("-");
    }
    return stringBuilder.toString();
  }

  public List<Car> winnerView(List<Car> cars) {
    int longest = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElseThrow(() -> new RuntimeException("무엇인가 이상하네요."));

    return cars.stream()
        .filter(car -> car.getPosition() == longest)
        .collect(Collectors.toList());
  }

  public List<Integer> getResultListSize() {
    return resultList.stream().map(String::length).collect(Collectors.toList());
  }

  public static ResultView create(Game game) {
    return new ResultView(game);
  }
}
