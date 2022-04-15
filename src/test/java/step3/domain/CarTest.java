package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step3.domain.Car.DEFAULT_POSITION;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void createCarTest() {
        Car carCreated = new Car("car1");

        assertThat(carCreated).isNotNull();
        assertThat(carCreated.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @DisplayName("차 이름의 길이는 5 초과하면 예외 발생한다.")
    @Test
    void createCarTest2() {
        assertThatThrownBy(() -> new Car("carName"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차 이름은 알파벳과 숫자 외의 Character 가 있으면 예외 발생한다.")
    @Test
    void createCarTest3() {
        assertThatThrownBy(() -> new Car("한글은안됩니다!~"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차량 전진 요청 시 위치 전진한다.")
    @Test
    void carProceedTest() {
        assertThat(car.getPosition()).isEqualTo(1);

        car.proceed();

        assertThat(car.getPosition()).isEqualTo(2);
    }

}