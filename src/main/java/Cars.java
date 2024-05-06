import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> value;

    public Cars(List<Car> value) {
        this.value = value;
    }

    public List<Car> getValue() {
        return this.value;
    }

    public void move(MovePolicy movePolicy) {
        for (Car car : this.value) {
            car.move(movePolicy);
        }
    }

    public List<Car> findWinners() {
        return findCarsByPosition(findMaxPosition());
    }

    public int getCount() {
        return this.value.size();
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.value) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    private List<Car> findCarsByPosition(int maxPosition) {
        List<Car> cars = new ArrayList<>();

        this.value.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .forEach(cars::add);

        return cars;
    }
}
