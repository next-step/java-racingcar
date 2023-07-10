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

    public SimulationResultDto simulate() {
        List<List<CarVO>> roundResults = new ArrayList<>();

        roundResults.add(this.cars.getCars());
        for (int i = 0; i < this.count.getValue(); i++) {
            roundResults.add(this.cars.nextRound(this.numberGenerator));
        }
        List<CarVO> winners = this.cars.getWinners();
        return new SimulationResultDto(roundResults, winners);
    }
}
