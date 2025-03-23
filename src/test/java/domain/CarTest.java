package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 메소드 테스트")
class CarTest {

    @Test
    @DisplayName("자동차를 생성합니다")
    void create_car() {
        //given
        String carName = "car1";

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 이름은 비어있을 수 없습니다.")
    void create_car_자동차_이름_빈_값() {
        String name = "";

        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 비어 있을 수 없습니다");

    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없습니다.")
    void create_car_자동차_이름_5자_초과() {
        String name = "abcdef";

        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다");

    }

    @DisplayName("숫자가 4보다 같거나 크면 앞으로 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_greater_equal_four(int input) {
        Car car = new Car("a");

        car.move(input);

        assertThat(car.isSame(1)).isTrue();

    }

    @DisplayName("숫자가 4보다 작으면 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void move_less_four(int input) {
        Car car = new Car("a");
        car.move(input);
        assertThat(car.isSame(0)).isTrue();
    }

}