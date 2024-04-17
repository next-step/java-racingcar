package step4_winner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차의 기본 거리는 1이고, move에 4이상의 값이 주어지면 distance가 증가한다")
    void CarMoveTest() {

        // GIVEN
        String legalName = "test1";

        // WHEN
        Car car = new Car(legalName); //이름 넣도록 추가

        // THEN
        assertThat(car.getDistance()).isEqualTo(1);
        assertThat(car.getName()).isEqualTo("test1");

        // WHEN : 안움직임
        car.move(3);
        // THEN
        assertThat(car.getDistance()).isEqualTo(1);

        // WHEN : 움직임
        car.move(4);
        // THEN
        assertThat(car.getDistance()).isGreaterThan(1);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    void carNameNotLongerThan5Test() {
        // GIVEN
        String IllegalCarName = "5charover";

        // WHEN
        Throwable IllegalThrown = catchThrowable(() -> new Car(IllegalCarName));

        // THEN
        assertThat(IllegalThrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과할 수 없습니다");
    }
}