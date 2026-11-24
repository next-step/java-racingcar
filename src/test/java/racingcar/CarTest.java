package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("자동차의 최초 전진 상태는 0 이다.")
    @Test
    public void test_1() {
        assertThat(new Car(0, "john").getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차에 4 이상의 값 명령을 내리면 자동차는 전진한다. : 4 명령 시 전진한다. (경계값)")
    @Test
    public void test_2() {
        Car car = new Car("john");
        car.tryMove(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차에 4 미만의 값 명령을 내리면 자동차는 멈춘다. : 3 명령 시 멈춘다. (경계값)")
    @Test
    public void test_3() {
        Car car = new Car("john");
        car.tryMove(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 현재 전진 상태를 int 값으로 알 수 있다. (현재 전진 상태가 5라면 5)")
    @Test
    public void test_4() {
        assertThat(new Car(5, "john").getPosition()).isEqualTo(5);
    }

    @DisplayName("자동차의 이름이 5자이면 생성에 성공한다. (5자 → 성공)")
    @Test
    public void test_5() {
        assertThatNoException().isThrownBy(() -> new Car("abcde"));
    }

    @DisplayName("자동차의 이름이 5자를 초과하면 RuntimeException (6자 → 실패)")
    @Test
    public void test_6() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("5자");
    }

    @DisplayName("자동차의 이름이 비어있거나 공백이면 RuntimeException")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void test_7(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("비어");
    }

    @DisplayName("이름이 같으면 위치가 달라도 같은 자동차다. (john 0, john 3 → 같음)")
    @Test
    public void test_8() {
        assertThat(new Car(0, "john")).isEqualTo(new Car(3, "john"));
    }

    @DisplayName("이름이 다르면 위치가 같아도 다른 자동차다. (john 0, tom 0 → 다름)")
    @Test
    public void test_9() {
        assertThat(new Car(0, "john")).isNotEqualTo(new Car(0, "tom"));
    }
}
