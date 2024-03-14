package step3.application.domain;

import step3.application.domain.model.OneMoveRecord;
import step3.application.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;
    public static final int MOVE_THRESHOLD = 4;

    public RacingCars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public OneMoveRecord moveCars() {
        List<Integer> oneMoveResult = this.cars.stream()
                .map(car -> car.move(canMove()))
                .collect(Collectors.toList());
        return new OneMoveRecord(oneMoveResult);
    }

    private boolean canMove() {
        return numberGenerator.drawNumber() >= MOVE_THRESHOLD;
    }
}