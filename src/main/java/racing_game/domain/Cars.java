package racing_game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import racing_game.core.Positive;

public class Cars {

    private final List<Car> holder;

    private Cars(int count) {
        Random random = new Random();
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

    public Distances getDistances() {
        return Distances.create(
            holder.stream().map(Car::getDistance).collect(Collectors.toUnmodifiableList()));
    }

    public int size() {
        return holder.size();
    }
}
