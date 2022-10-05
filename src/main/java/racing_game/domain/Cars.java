package racing_game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racing_game.core.Positive;

public class Cars {

    private final List<Car> holder;

    private Cars(Positive count, int bound, int condition) {
        holder = new ArrayList<>();
        for (int i = 0; i < count.toInt(); i++) {
            Car car = Car.create(new RandomMoving(bound, condition));
            holder.add(car);
        }
    }

    public static Cars create(Positive count, int bound, int condition) {
        return new Cars(count, bound, condition);
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
