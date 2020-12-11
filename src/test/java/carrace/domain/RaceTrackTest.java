package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    }

    @Test
    void startingPointNextTest() {
        RacingRule racingRule = new FixedRacingRule();
        RaceTrack raceTrack = new RaceTrack(racingRule,3);
        raceTrack.next();

        for (Car car : raceTrack.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("우승자가 1명일 경우")
    void getWinnerTest() {
        //given
        Car car1 = new Car(2, "a");
        Car car2 = new Car(4, "b");
        Car car3 = new Car(8, "c");
        RacingRule racingRule = new FixedRacingRule();
        RaceTrack raceTrack = new RaceTrack(racingRule, car1, car2, car3);

        //when
        List<Car> winner = raceTrack.getWinner();

        //then
        assertThat(winner).contains(car3);
    }


    @Test
    @DisplayName("우승자가 2명 이상일 경우(우승자가 중간에 있음)")
    void getMultiWinnerCase1Test() {
        //given
        Car car1 = new Car(8, "a");
        Car car2 = new Car(2, "b");
        Car car3 = new Car(1, "c");
        Car car4 = new Car(8, "d");
        Car car5 = new Car(2, "e");
        RacingRule racingRule = new FixedRacingRule();
        RaceTrack raceTrack = new RaceTrack(racingRule, car1, car2, car3, car4, car5);

        //when
        List<Car> winner = raceTrack.getWinner();

        //then
        assertThat(winner).contains(car1, car4);
    }


    @Test
    @DisplayName("우승자가 2명 이상일 경우(모두 같은 경우)")
    void getMultiWinnerCase2Test() {
        //given
        Car car1 = new Car(2, "a");
        Car car2 = new Car(2, "b");
        Car car3 = new Car(2, "c");
        Car car4 = new Car(2, "d");
        Car car5 = new Car(2, "e");
        RacingRule racingRule = new FixedRacingRule();
        RaceTrack raceTrack = new RaceTrack(racingRule, car1, car2, car3, car4, car5);

        //when
        List<Car> winner = raceTrack.getWinner();

        //then
        assertThat(winner).contains(car1, car2, car3, car4, car5);
    }

    @Test
    public void getRacingResultTest() {
        Car car1 = new Car(2, "a");
        Car car2 = new Car(4, "b");
        Car car3 = new Car(8, "c");
        RacingRule racingRule = new FixedRacingRule();
        RaceTrack raceTrack = new RaceTrack(racingRule, car1, car2, car3);
        assertThat(raceTrack.getRacingResult()).isEqualTo(
                "a : --\n" +
                "b : ----\n" +
                "c : --------\n"
        );
    }

    @Test
    public void getWinnerResultTest() {
        Car car1 = new Car(2, "a");
        Car car2 = new Car(4, "b");
        Car car3 = new Car(8, "c");
        RacingRule racingRule = new FixedRacingRule();
        RaceTrack raceTrack = new RaceTrack(racingRule, car1, car2, car3);
        assertThat(raceTrack.getWinnerResult()).isEqualTo(
                "c가 최종 우승했습니다."
        );
    }
}