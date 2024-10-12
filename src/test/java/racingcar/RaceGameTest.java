package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RaceGame;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceGameTest {

    @DisplayName("원하는 값 만큼 경주에 참가할 자동차를 생성할 수 있다.")
    @Test
    void createCompetitorTest() {
        //given
        List<Car> cars = List.of(
                new Car(new RandomNumberGenerator()),
                new Car(new RandomNumberGenerator())
        );
        RaceGame raceGame = new RaceGame(2, cars);
        //then
        assertThat(raceGame).isNotNull();
        assertThat(raceGame.getCars()).hasSize(2);
    }

    @DisplayName("경기 시, 주행 횟수 만큼 각 라운드별 결괏값이 생성된다.")
    @Test
    void raceGameTest() {
        //given
        List<Car> cars = List.of(
                new Car(new RandomNumberGenerator()),
                new Car(new RandomNumberGenerator())
        );
        RaceGame raceGame = new RaceGame(2, cars);
        //when
        raceGame.startRace();
        //then
        assertThat(raceGame.getResults()).hasSize(2);
    }
}