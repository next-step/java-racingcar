package race;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final int numOfCars;
    private final PowerGenerator powerGenerator;

    public Cars(int numOfCars, PowerGenerator powerGenerator) {
        this.numOfCars = numOfCars;
        this.powerGenerator = powerGenerator;
    }

    public MoveResults orderMove() {
        List<MoveResult> result = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            result.add(
                    Car.move(powerGenerator.generate())
            );
        }
        return new MoveResults(result);
    }
}
