package racing_game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racing_game.core.Positive;

public class Cars {

    private final List<Car> holder;

    private Cars(Positive count) {
        holder = new ArrayList<>();
        for (int i = 0; i < count.toInt(); i++) {
            holder.add(Car.create());
        }
    }

    public static Cars create(Positive count) {
        return new Cars(count);
    }

    public void moveAll(MovingStrategy movingStrategy) {
        for (Car car : holder) {
            car.move(movingStrategy);
        }
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(holder);
    }

    public int size() {
        return holder.size();
    }
}
