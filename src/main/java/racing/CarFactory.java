package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;

public class CarFactory {
    public static final int MOVE_POWER_BOUND = 10;
    public static final int DEFAULT_MOVE_POWER_CONDITION = 4;

    public static final BooleanSupplier mustGoMoveConditionSupplier = () -> true;
    public static final BooleanSupplier randomMoveConditionSupplier = () -> new Random().nextInt(MOVE_POWER_BOUND) >= DEFAULT_MOVE_POWER_CONDITION;

    public static List<Car> createRacingCars(String[] carNames) {
        return createRacingCars(carNames, randomMoveConditionSupplier);
    }

    public static List<Car> createRacingCars(String[] carNames, BooleanSupplier moveConditionSupplier) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], moveConditionSupplier));
        }
        return cars;
    }
}
