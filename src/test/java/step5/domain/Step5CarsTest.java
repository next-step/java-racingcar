package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.car.Cars;

public class Step5CarsTest {
    private Cars cars;

    @BeforeEach
    void settingCars(){
        // given
        String names = "포비, 그르릉, 아톰";

        // when
        cars = Cars.defaultOf(names);
    }

    @Test
    @DisplayName("시합 자동차 생성 테스트")
    void make_cars() {
        // then
        Assertions.assertThat(cars.hasSize(3)).isTrue();
    }
}
