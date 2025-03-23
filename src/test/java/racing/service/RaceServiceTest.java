package racing.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.FakeMovingStrategy;
import racing.domain.Cars;
import racing.domain.Name;
import racing.domain.Position;

class RaceServiceTest {
    @DisplayName("RaceService를 생성한다.")
    @Test
    void createTest() {
        // given
        List<String> carNames = List.of("BMW", "BENZ", "AUDI");

        // when
        RaceService sut = new RaceService(carNames, 1, new FakeMovingStrategy(4));

        // then
        assertThat(sut).isNotNull();
    }

    @DisplayName("주어진 횟수만큼 자동차 경주를 할 수 있다.")
    @Test
    void raceTest() {
        // given
        List<String> carNames = List.of("BMW");
        RaceService raceService = new RaceService(carNames, 5, new FakeMovingStrategy(5));
        Car bmw = new Car(new Name("BMW"), new Position(6));
        Cars cars = new Cars(List.of(bmw));

        // when
        raceService.race();

        // then
        assertThat(raceService.getCars()).isEqualTo(cars);
    }

    @DisplayName("Cars 객체를 가져올 수 있다.")
    @Test
    void getCarsTest() {
        // given
        RaceService raceService = new RaceService(List.of("AUDI"), 1, new FakeMovingStrategy(1));
        Car audi = new Car(new Name("AUDI"), new Position(1));
        Cars cars = new Cars(List.of(audi));

        // when then
        assertThat(raceService.getCars()).isEqualTo(cars);
    }

    @DisplayName("게임이 끝났는지 확인 할 수 있다.")
    @Test
    void gameEnd() {
        RaceService unFinishedRaceService = new RaceService(List.of("Benz"), 3, new FakeMovingStrategy(2));
        RaceService finishedRaceService = new RaceService(List.of("Benz"), 3, new FakeMovingStrategy(2));

        finishedRaceService.race();

        assertThat(unFinishedRaceService.gameEnd()).isFalse();
        assertThat(finishedRaceService.gameEnd()).isTrue();
    }
}
