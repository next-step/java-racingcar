package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("자동차 이름과 위치를 입력 받아서 객체 생성")
    public void carInitializeTest() {
        Car car = new Car("test", 1);
        assertThat(car.getName()).isEqualTo("test");
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름만 입력 받아서 객체 생성, 위치는 기본값 0로 고정")
    public void carInitializeWithDefaultLocationTest() {
        Car car = new Car("test2");
        assertThat(car.getName()).isEqualTo("test2");
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과일 경우, 에러 발생")
    public void carNameErrorIfOverFiveCharacter() {
        assertThatThrownBy(() -> new Car("다섯글자넘는")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 다섯 글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("movePoint가 4 이상일 때만 이동")
    public void carMoveTest() {
        Car car = new Car("test");
        car.move(4);

        assertThat(car.getCurrentLocation()).isEqualTo(1);

        car.move(2);
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("movePoint가 4 이하일 때 제자리에 멈춤")
    public void carMoveTest2_stop() {
        Car car = new Car("test", 0);
        car.move(1);

        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }
}
