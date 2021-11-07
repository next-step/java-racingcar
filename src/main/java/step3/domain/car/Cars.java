package step3.domain.car;

import step3.domain.board.RoundBoard;
import step3.domain.power.Engine;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class Cars {

    private final List<Car> cars;
    private final Engine engine;

    public Cars(List<Car> cars, Engine engine) {
        checkArgument(cars != null, "cars is required");
        checkArgument(engine != null, "engine is required");
        this.cars = cars;
        this.engine = engine;
    }

    public void go() {
        cars.forEach(car -> {
            int generatedPower = engine.generatePower();
            car.go(generatedPower);
        });
    }

    public void recordRound(RoundBoard roundBoard) {
        checkArgument(cars != null, "roundBoard is required");
        for (Car car : cars) {
            car.record(roundBoard);
        }
    }
}
