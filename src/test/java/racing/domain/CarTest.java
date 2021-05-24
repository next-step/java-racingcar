package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Cars cars = new Cars();

    @DisplayName("차 이름 리스트에 담기")
    @Test
    void getCarName() {
        assertThat(cars.initCarName("chloe,chloe")).containsExactly("chloe", "chloe");
    }

    @DisplayName("차 이름 5자가 넘으면 예외처리")
    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> cars.initCarName("chloe,chloeJ")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤값에 따른 차 이동 여부 확인")
    @Test
    void getRandomMoveTest() {
        Car car = new Car("1");
        car.getRandomMove(8);

        assertThat(car.getRandomMove(8).getMovingRange()).isEqualTo(1);
    }
}
