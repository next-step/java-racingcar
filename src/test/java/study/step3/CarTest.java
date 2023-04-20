package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    Car car;

    @Test
    @DisplayName("0~9 사이 무작위 값을 반환한다.")
    public void random_함수_test() throws Exception {
        car = new Car("A", 0);
        for (int i = 0; i < 10; i++) {
            assertThat(car.getRandomInt())
                    .isGreaterThan(-1)
                    .isLessThan(10);
        }
    }

    @Test
    @DisplayName("전달 받은 값이 4 이상일 경우 true를 반환한다.")
    public void car_move_test() throws Exception {
        car = new Car("A", 0);
        assertThat(car.isExceedStandard(5)).isTrue();
        assertThat(car.isExceedStandard(4)).isTrue();
        assertThat(car.isExceedStandard(3)).isFalse();
    }

    @DisplayName("차량 이름 등록 시, 정합성을 테스트한다.")
    @ParameterizedTest
    @ValueSource(strings = {"빨강", "파랑", "black"})
    public void car_생성자_테스트(String carName) throws Exception {
        assertThat(new Car(carName).getName()).isEqualTo(carName);
    }

    @DisplayName("차량 이름 등록 시, 5글자를 초과할 수 없다.")
    @ValueSource(strings = {"hyundai", "porsche", "lamborghini"})
    @ParameterizedTest
    public void 차량_이름_요구사항_테스트(String carName) throws Exception {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(InvalidParameterException.class);
    }
}
