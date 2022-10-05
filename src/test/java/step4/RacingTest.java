package step4;

import org.junit.jupiter.api.BeforeEach;

public class RacingTest {
    Cars cars;
    Racing racing;
    OutputRacingCar outputResult;

    @BeforeEach
    void init() {
        racing = new Racing();
        outputResult = new OutputRacingCar();
        cars = new Cars();
    }
}
