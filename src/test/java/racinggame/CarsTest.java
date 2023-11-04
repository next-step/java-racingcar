package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("성공 - 레이싱 경주를 끝마친 후 자동차들의 위치값을 구한다.")
    void success_racing_car() {
        // given
        Cars cars = new Cars(
                List.of(
                        new Car(0, new TestNumber(0)),
                        new Car(0, new TestNumber(5)),
                        new Car(0, new TestNumber(9))
                )
        );

        // when
        cars.startRacing(5);

        // then
        assertThat(cars.getCar()).hasSize(3)
                .extracting("position")
                .containsOnly(0, 5, 5);

    }

}
