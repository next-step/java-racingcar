package racingcar.dto;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class RaceResponseTest {

    @Test
    void RaceResponse생성할때_성공() {
        // given
        final Cars cars = Cars.of(new String[]{"pobi", "crong", "honux"});

        // when & then
        assertThatNoException().isThrownBy(() -> new RaceResponse(cars));
    }

    @Test
    void CarResponse생성할때_성공() {
        // given
        final Name name = Name.from("pobi");

        // when
        RaceResponse.CarResponse carResponse = new RaceResponse.CarResponse(Car.create(name.getValue()));

        // then
        assertThat(carResponse.getName()).isEqualTo(name.getValue());
        assertThat(carResponse.getPosition()).isZero();
    }
}
