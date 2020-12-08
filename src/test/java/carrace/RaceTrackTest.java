package carrace;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTrackTest {

    @RepeatedTest(30)
    void nextTest() {
        Car car1 = new Car(2);
        Car car2 = new Car(4);
        Car car3 = new Car(8);

        RaceTrack raceTrack = new RaceTrack(car1, car2, car3);
        raceTrack.next();

        assertThat(car1.getPosition()).isIn(2, 3);
        assertThat(car2.getPosition()).isIn(4, 5);
        assertThat(car3.getPosition()).isIn(8, 9);

        assertThat(car1.toString()).isIn("--", "---");
        assertThat(car2.toString()).isIn("----", "-----");
        assertThat(car3.toString()).isIn("--------", "---------");
    }

}