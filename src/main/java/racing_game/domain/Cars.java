package racing_game.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;
import racing_game.core.Positive;

public class Cars implements Iterable<Car> {

  private List<Car> holder;
  Random random;

  private Cars(int numberOfCars) {
    random = new Random();
    holder = new ArrayList<>();
    for (int i = 0; i < numberOfCars; i++) {
      holder.add(Car.create(random));
    }
  }

  public static Cars create(Positive numberOfCars) {
    return new Cars(numberOfCars.toInteger());
  }

  public void moveAll() {
    for (Car car : holder) {
      car.move();
    }
  }

  @Override
  public Iterator<Car> iterator() {
    return holder.iterator();
  }

  @Override
  public void forEach(Consumer<? super Car> action) {
    holder.forEach(action);
  }

  @Override
  public Spliterator<Car> spliterator() {
    return holder.spliterator();
  }
}
