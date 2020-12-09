package carrace.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTrackTest {

    @Test
    void nextTest() {
        Car car1 = new Car(2);
        Car car2 = new Car(4);
        Car car3 = new Car(8);
        RacingRule racingRule = new FixedRacingRule();
        RaceTrack raceTrack = new RaceTrack(racingRule, car1, car2, car3);

        raceTrack.next();

        assertThat(car1.getPosition()).isIn(3);
        assertThat(car2.getPosition()).isIn(5);
        assertThat(car3.getPosition()).isIn(9);

        assertThat(car1.toString()).isEqualTo("---");
        assertThat(car2.toString()).isEqualTo("-----");
        assertThat(car3.toString()).isEqualTo("---------");
    }

    @Test
    void startingPointNextTest() {
        RacingRule racingRule = new FixedRacingRule();
        RaceTrack raceTrack = new RaceTrack(racingRule,3);
        raceTrack.next();

        for (Car car : raceTrack.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(2);
            assertThat(car.toString()).isEqualTo("--");
        }
    }

}