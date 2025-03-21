package racing.domain;

import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class CarFactory {
    public static final int MOVE_POWER_BOUND = 10;
    public static final int DEFAULT_MOVE_POWER_CONDITION = 4;

    public static final BooleanSupplier mustGoMoveConditionSupplier = () -> true;
    public static final BooleanSupplier randomMoveConditionSupplier = () -> new Random().nextInt(MOVE_POWER_BOUND) >= DEFAULT_MOVE_POWER_CONDITION;

    public static List<Car> createRacingCars(List<String> carNames) {
        return createRacingCars(carNames, randomMoveConditionSupplier);
    }

    public static List<Car> createRacingCars(List<String> carNames, BooleanSupplier moveConditionSupplier) {
        return carNames.stream()
                .map(name -> new Car(name, moveConditionSupplier))
                .collect(Collectors.toList());
    }
}
