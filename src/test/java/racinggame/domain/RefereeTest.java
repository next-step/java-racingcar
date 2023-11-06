package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.strategy.TestMove;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    @DisplayName("성공 - 레이싱 경주를 끝마친 후 자동차들의 위치값을 구한다.")
    void success_racing_car() {
        // given
        Referee referee = new Referee();
        Cars cars = new Cars(
                List.of(
                        new Car("a", new TestMove(0)),
                        new Car("b", new TestMove(5)),
                        new Car("c", new TestMove(9))
                )
        );

        // when
        referee.startRacing(5, cars);

        // then
        assertThat(cars.getCars()).hasSize(3)
                .extracting("position")
                .containsOnly(0, 5, 5);
    }

}
