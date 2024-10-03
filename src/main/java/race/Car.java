package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {
    private int step;

    private Car(int step) {
        this.step = step;
    }

    public int moveBy(ICarMoveRule carMoveRule, int moveStep) {
        if (carMoveRule.check()) {
            this.step += moveStep;
        }

        return this.step;
    }

    public static Car create(int startStep) {
        return new Car(startStep);
    }

    public static List<Car> create(int startStep, int count) {
        return Stream.generate(() -> Car.create(startStep)).limit(count).collect(Collectors.toList());
    }
}
