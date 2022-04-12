package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car.Cars;

@DisplayName("Cars 테스트")
class CarsTest {

    @Test
    @DisplayName("자동차 N개 생성 테스트")
    void createNCarsTest() {
        // given
        int count = 4;
        // when
        Cars cars = Cars.of(count);
        // then
        assertThat(cars.getCars().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("게임 Play 테스트")
    void playTest() {
        // given
        Cars cars = Cars.of(1);
        // when
        cars.play();
        // then
        assertThat(cars.getCars().get(0).getState()).isLessThanOrEqualTo(1);
    }
}