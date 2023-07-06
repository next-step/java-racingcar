package racing.model;

import racing.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final Count count;

    public RacingManager(List<String> cars, NumberGenerator numberGenerator, int countValue) {
        this.cars = new Cars(cars);
        this.numberGenerator = numberGenerator;
        this.count = new Count(countValue);
    }

    public SimulationResult simulate() {
        List<List<CarVO>> progress = new ArrayList<>();

        progress.add(this.cars.getCars());
        for (int i = 0; i < this.count.getValue(); i++) {
            progress.add(this.cars.nextStep(this.numberGenerator));
        }
        List<CarVO> winners = this.cars.getWinners();
        return new SimulationResult(progress, winners);
    }
}
