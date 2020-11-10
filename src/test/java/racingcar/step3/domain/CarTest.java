package racingcar.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step3.common.Consts;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created : 2020-11-02 오전 10:11
 * Developer : Seo
 */
class CarTest {

    Car car = null;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("차량 이름")
    void getName() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @ValueSource(strings = {"123456"})
    void givenUnqualified_thenThrowException(String s) {
        assertThatIllegalArgumentException().isThrownBy(() -> car = new Car(s))
                .withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("멈춤 거리 확인")
    void whenStay_thenGetDistance() {
        this.car.move(Consts.INVALID_VALUE);
        assertThat(car.getDistance()).isZero();
    }

    @Test
    @DisplayName("이동 후 거리 확인")
    void whenMove_thenGetDistance() {
        this.car.move(Consts.INVALID_VALUE + 1);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}