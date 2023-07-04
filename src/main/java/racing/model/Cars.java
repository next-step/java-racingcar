package racing.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> original;

    public Cars(List<Car> original) {
        this.original = original;
    }

    public int size() {
        return this.original.size();
    }

    public void moveOneStepMoreThanCriterion(int idx, int randomValue) {
        this.original.get(idx)
                     .moveOneStepMoreThanCriterion(randomValue);
    }

    public List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return this.original.stream()
                            .filter(cur -> cur.isWinner(maxPosition))
                            .map(Car::getName)
                            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        original.forEach(car -> builder.append(car).append('\n'));
        return builder.toString();
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (Car car : this.original) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

}
