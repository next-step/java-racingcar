package racing_game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racing_game.core.Positive;

public class Cars {

    private final RandomGenerator randomGenerator;
    private final List<Car> holder;

    private Cars(Positive count) {
        randomGenerator = RandomGenerator.create();
        holder = new ArrayList<>();
        for (int i = 0; i < count.toInt(); i++) {
            holder.add(Car.create());
        }
    }

    public static Cars create(Positive count) {
        return new Cars(count);
    }

    public void moveAll() {
        for (Car car : holder) {
            car.move(randomGenerator.getRandomValue());
        }
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(holder);
    }

    public int size() {
        return holder.size();
    }
}
