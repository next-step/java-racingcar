package step4.domain.car;

import javafx.geometry.Pos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.position.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String name = "test";

        // when
        Car car = new Car(name);

        // test
        assertThat(car).isNotNull();
    }

    @DisplayName("Car 인스턴스 이동 여부 테스트")
    @Test
    void 이동() {
        // given
        Car car = new Car("test");

        // when
        car.move(() -> true);
        Position position = car.position();
        int actual =  position.position();

        // then
        assertThat(actual).isEqualTo(1);
    }

}