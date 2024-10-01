package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceGameTest {


    @DisplayName("원하는 값 만큼 경주에 참가할 자동차를 생성할 수 있다.")
    @Test
    void createCompetitorTest() {
        //given
        List<Car> cars = List.of(new Car(), new Car());
        RaceGame raceGame = new RaceGame(2, cars);
        //then
        assertThat(raceGame).isNotNull();
        assertThat(raceGame.getCars()).hasSize(2);
    }
}
