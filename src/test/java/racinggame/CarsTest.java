package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.Cars;
import racinggame.car.Count;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CarsTest {

    @DisplayName("자동차 대수 값이 0보다 큰 숫자 이외의 값이 들어왔을 경우 에러 처리 테스트")
    @Test
    void car_count_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cars(new Count(-1)))
                .withMessage("시도할 회수는 0보다 큰 숫자여야 합니다.");
    }

    @DisplayName("입력 숫자 만큼 Car 객체를 만들 수 있다.")
    @Test
    void init_cars() {
        assertThat(new Cars(new Count(3)).getCars().size()).isEqualTo(3);
    }
}
