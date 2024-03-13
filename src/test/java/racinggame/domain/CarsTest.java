package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void raceStart_주행_결과() {
        Cars cars = new AlwaysMoveCars(new CarsNames("one", "two", "three"));
        RaceRecorder recorder = new RaceRecorder();
        RaceCount raceCount = new RaceCount(3);

        cars.raceStart(raceCount, recorder);

        assertThat(recorder.getRecords().get(2).getCars())
                .contains(
                        new Car(new Position(3), new CarName("one"))
                        , new Car(new Position(3), new CarName("two"))
                        , new Car(new Position(3), new CarName("three"))
                );
    }

    @Test
    void raceStart_정지_결과() {
        Cars cars = new NeverMoveCars(new CarsNames("one", "two", "three"));
        RaceRecorder recorder = new RaceRecorder();
        RaceCount raceCount = new RaceCount(3);

        cars.raceStart(raceCount, recorder);

        assertThat(recorder.getRecords().get(2).getCars())
                .contains(
                        new Car(new Position(), new CarName("one"))
                        , new Car(new Position(), new CarName("two"))
                        , new Car(new Position(), new CarName("three"))
                );
    }
}
