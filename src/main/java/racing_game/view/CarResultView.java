package racing_game.view;

import racing_game.core.Positive;
import racing_game.core.SnapShot;
import racing_game.domain.Distances;

public class CarResultView implements ResultView<SnapShot<Distances>> {

  private CarResultView() {}

  public static CarResultView create() {
    return new CarResultView();
  }

  @Override
  public String resolve(SnapShot<Distances> distanceSnapShot) {
    StringBuilder sb = new StringBuilder("실행 결과\n");
    int i = 0;
    for (Distances distances : distanceSnapShot) {
      sb.append(++i).append(" 회차 ---------------\n");
      draw(distances, sb);
      sb.append("\n");
    }
    return sb.toString();
  }

  private void draw(Distances distances, StringBuilder sb) {
    for (Positive distance : distances) {
      sb.append("_ ".repeat(distance.toInt())).append("\n");
    }
  }
}
