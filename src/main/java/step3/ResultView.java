package step3;

import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class ResultView {
  private static final InputView inputView = new InputView();

  public void resultPrint(Set<Car> carSet) {
    int move = inputView.setMoveCount();

    carSet.forEach(car -> {
      move(move, car);
      System.out.println();
    });
  }

  private void move(int move, Car car) {
    IntStream.range(0, move)
            .map(i -> new Random().nextInt(9))
            .filter(randomNumber -> randomNumber >= 4)
            .forEach(randomNumber -> car.setMove());
  }
}
