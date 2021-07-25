package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {
    @DisplayName("주어진 개수만큼 자동차 객체가 생성되어야한다.")
    @Test
    void cars() {
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @DisplayName("시도 후 점수가 달라져야한다.")
    @Test
    void getScores() {
        Cars cars = new Cars(Collections.singletonList("pobi"));
        int before = cars.getCars().get(0).getScore();
        for (int i = 0; i < 5; i++) {
            cars.attempt();
        }
        int after = cars.getCars().get(0).getScore();
        assertThat(after).isNotEqualTo(before);
    }

    @DisplayName("자동차 이름이 5자를 초과하면 에러")
    @Test
    void cars_error() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(Arrays.asList("pobieee", "crong", "honux")));
    }

}
