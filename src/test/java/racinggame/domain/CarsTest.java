package racinggame.domain;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void raceStart() {
        Cars cars = new AlwaysMoveCars(new CarsNames("one", "two", "three"));
        RaceRecorder recorder = new RaceRecorder();
        RaceCount raceCount = new RaceCount(3);

        cars.raceStart(raceCount, recorder);

    }
}
