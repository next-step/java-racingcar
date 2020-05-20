package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
      System.out.println(currentView);
    }
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

  public Game getGame() {
    return game;
  }

  public List<String> getResultList() {
    return resultList;
  }

  public List<Integer> getResultListSize() {
    return resultList.stream().map(String::length).collect(Collectors.toList());
  }

  public static ResultView create(Game game) {
    return new ResultView(game);
  }
}
