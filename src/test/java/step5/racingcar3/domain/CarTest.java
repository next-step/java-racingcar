package step5.racingcar3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("고장난 엔진을 달았을 때 자동차가 앞으로 못가는지")
    void givenAlwaysStopThreshold_whenRacingCarRun_thenRacingCarStop() {
        // given
        CarName carName = new CarName("asdf");
        CarEngine carEngineBroken = new CarEngine(CarEngine.ALWAYS_STOP_THRESHOLD);
        Position position = new Position(Position.MIN_POSITION);
        Car car = new Car(carName, carEngineBroken, position);

        // when
        car.run();

        // then
        assertThat(car.position().equals(new Position(Position.MIN_POSITION))).isTrue();
    }

    @Test
    @DisplayName("베스트 엔진을 달았을 때 자동차가 앞으로 가는지")
    void givenAlwaysGoThreshold_whenRacingCarRun_thenRacingCarGo() {
        // given
        CarName carName = new CarName("qwer");
        CarEngine carEngineBest = new CarEngine(CarEngine.ALWAYS_GO_THRESHOLD);
        Position position = new Position(Position.MIN_POSITION);

        Car car = new Car(carName, carEngineBest, position);

        // when
        car.run();

        // then
        assertThat(car.position().equals(new Position(Position.MIN_POSITION+1))).isTrue();
    }

}
