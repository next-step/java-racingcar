package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {

    @Test
    void 사용자_입력값_만큼의_자동차를_생성할_수_있다() {

        Cars cars = new Cars(
                List.of(
                        new Car("pobi"),
                        new Car("jason"),
                        new Car("jobi"))
        );
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}
