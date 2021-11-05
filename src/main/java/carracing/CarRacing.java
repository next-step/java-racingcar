package carracing;

import java.util.HashMap;
import java.util.Map;

public class CarRacing {

    private Map<Integer, String> cars;

    private Integer movementQuantity;

    public CarRacing(Integer carsQuantity, Integer movementQuantity) throws IllegalArgumentException {
        valid(carsQuantity, movementQuantity);

        this.carsSetUp(carsQuantity);
        this.movementQuantity = movementQuantity;
    }

    private void carsSetUp(Integer carsQuantity) {
        cars = new HashMap<>();
        for (int i = 0; i < carsQuantity; i++) {
            cars.put(i, RacingUtils.DASH);
        }
    }

    public Integer getMovementQuantity() {
        return this.movementQuantity;
    }

    public void run(Integer key) {
        validKey(key);

        String move = cars.get(key);
        cars.put(key, move + RacingUtils.DASH);
    }

    public Integer getCarsSize() {
        return cars.size();
    }

    public Map<Integer, String> getCars() {
        return this.cars;
    }

    private void valid(Integer carsQuantity, Integer movementQuantity) throws IllegalArgumentException {
        if (carsQuantity < 1) {
            throw new IllegalArgumentException(RacingUtils.CARS_QUANTITY_EXCEPTION);
        }

        if (movementQuantity < 1) {
            throw new IllegalArgumentException(RacingUtils.MOVEMENT_QUANTITY_EXCEPTION);
        }
    }

    private void validKey(Integer key) {
        if (!cars.containsKey(key)) {
            throw new NullPointerException(RacingUtils.CARS_NON_KEY);
        }
    }
}
