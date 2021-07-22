package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CarsTest {
    @DisplayName("자동차 대수 값이 1보다 작으면 IllegalArgumentException을 반환한다")
    @Test
    void carCountTest() {
        //given, when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cars(new Count(-1)))
                .withMessage("0보다 큰 숫자여야 합니다.");
    }

    @DisplayName("입력 숫자 만큼 Car 객체를 만들 수 있다.")
    @Test
    void initCars() {
        //given
        Count count = new Count(3);

        //when
        Cars cars = new Cars(count);

        //then
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}