package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.strategy.TestMove;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class CarsTest {

    @Test
    @DisplayName("성공 - 레이싱 1회 후 자동차들의 위치값을 구한다.")
    void success_racing_car() {
        // given
        Cars cars = new Cars(
                List.of(
                        new Car(new Name("a"), new TestMove(0)),
                        new Car(new Name("b"), new TestMove(5)),
                        new Car(new Name("c"), new TestMove(9))
                )
        );

        // when
        cars.racing();

        // then
        assertThat(cars.getCars()).hasSize(3)
                .extracting("position")
                .containsOnly(0, 1, 1);
    }

    @Test
    @DisplayName("성공 - 레이싱이 끝난 후 우승자를 구한다.")
    void success_racing_winners() {
        // given
        Cars cars = new Cars(
                List.of(
                        new Car(new Name("a"), new TestMove(0)),
                        new Car(new Name("b"), new TestMove(5)),
                        new Car(new Name("c"), new TestMove(9))
                )
        );
        fiveStepRacing(cars);

        // when
        List<Car> winners = cars.findWinners();

        // then
        assertThat(winners).hasSize(2)
                .extracting("carName", "position")
                .containsExactly(
                        tuple(new Name("b"), 5),
                        tuple(new Name("c"), 5)
                );
    }

    private void fiveStepRacing(Cars cars) {
        cars.racing();
        cars.racing();
        cars.racing();
        cars.racing();
        cars.racing();
    }

}
