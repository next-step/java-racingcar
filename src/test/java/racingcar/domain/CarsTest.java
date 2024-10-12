package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {

    public static final List<String> CAR_NAMES = List.of("pobi", "jason", "jobi");

    @Test
    void 사용자_입력값_만큼의_자동차를_생성할_수_있다() {
        Cars cars = new Cars(CAR_NAMES);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}
