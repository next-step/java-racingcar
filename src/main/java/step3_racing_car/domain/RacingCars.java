package step3_racing_car.domain;

import step3_racing_car.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> items;

    public RacingCars(List<RacingCar> items) {
        this.items = items;
    }

    // todo : 전략이 여기까지 올라오는게 맞나?
    public void movePosition(MovingStrategy movingStrategy) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).movePositions(movingStrategy.move());
        }
    }

    public List<RacingCar> matchPositionList(int maxPosition) {
        List<RacingCar> cars = new ArrayList<>();
        for (RacingCar car : this.items) {
            if (car.isMatch(maxPosition)) {
                cars.add(car);
            }
        }
        return cars;
    }

    public int maxPositionValue() {
        int maxPosition = 0;
        for (RacingCar car : this.items) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public List<RacingCar> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (RacingCar car : this.items) {
            stringBuilder.append(car.getName().toString());

            if (count == this.items.size() - 1) {
                break;
            }

            stringBuilder.append(",");
            count++;
        }
        return stringBuilder.toString();
    }
}
