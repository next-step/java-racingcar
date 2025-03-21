package race;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTrackTest {
    @Test
    void valid_car_count() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateCarCount(5)).isTrue();
    }

    @Test
    void invalid_car_count() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateCarCount(0)).isFalse();
        assertThat(racingTrack.validateCarCount(15)).isFalse();
    }

    @Test
    void valid_attempt_count() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateAttemptCount(5)).isTrue();
    }

    @Test
    void invalid_attempt_count() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateAttemptCount(0)).isFalse();
        assertThat(racingTrack.validateAttemptCount(15)).isFalse();
    }

    @Test
    void valid_car_names() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateCarNames(new String[]{"test1", "test2"})).isTrue();
    }

    @Test
    void invalid_car_names() {
        RacingTrack racingTrack = new RacingTrack(10, 10);
        assertThat(racingTrack.validateCarNames(new String[]{"", "test2"})).isFalse();
        assertThat(racingTrack.validateCarNames(new String[]{"testtesttest", "test2"})).isFalse();
        assertThat(racingTrack.validateCarNames(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"})).isFalse();
    }

    @Test
    void one_winner_test() {
        RacingCar car1 = new RacingCar("1");
        RacingCar car2 = new RacingCar("2");
        List<RacingCar> cars = new ArrayList<>(List.of(car1, car2));
//        RacingTrack racingTrack = new RacingTrack(10, 10);
//        racingTrack.startRace(cars, 5);
//        List<RacingCar> winners = racingTrack.getWinners();
//        assertThat(winners.size()).isEqualTo(1);
//        assertThat(winners.get(0)).isEqualTo(car1);
    }

    @Test
    void two_winner_test() {
        RacingCar car1 = new RacingCar("1");
        RacingCar car2 = new RacingCar("2");
        RacingCar car3 = new RacingCar("3");
        List<RacingCar> cars = new ArrayList<>(List.of(car1, car2, car3));
//        RacingTrack racingTrack = new RacingTrack(10, 10);
//        racingTrack.startRace(cars, 5);
//        List<RacingCar> winners = racingTrack.getWinners();
//        assertThat(winners.size()).isEqualTo(2);
//        assertThat(winners.get(0)).isEqualTo(car1);
//        assertThat(winners.get(1)).isEqualTo(car3);
    }
}
