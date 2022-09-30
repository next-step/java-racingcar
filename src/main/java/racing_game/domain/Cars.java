package racing_game.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;
import racing_game.core.Positive;

public class Cars implements Iterable<Car> {

  private final List<Car> holder;
  private final Random random;

  private Cars(int count) {
    random = new Random();
    holder = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      holder.add(Car.create(random));
    }
  }

  public static Cars create(Positive count) {
    return new Cars(count.toInt());
  }

  public void moveAll() {
    for (Car car : holder) {
      car.move();
    }
  }

  public int size() {
    return holder.size();
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
