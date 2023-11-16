package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Step5CarsTest {

    @Test
    @DisplayName("시합 자동차 생성 테스트")
    void make_cars() {
        // given
        String names = "포비, 그르릉, 아톰";

        // when
        Cars cars = Cars.defaultOf(names);

        // then
        Assertions.assertThat(cars.hasSize(3)).isTrue();
    }
}
