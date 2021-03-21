package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveTest {

    @Test
    @DisplayName("전진 테스트 - 전진 성공하는 경우")
    void 전진테스트(){
        Car car = new Car(new Name());
        car.move(() -> true);
        assertThat(car.position()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("전진 테스트 - 전진 실패하는 경우")
    void 전진조건테스트(){
        Car car = new Car(new Name());
        car.move(() -> false);
        assertThat(car.position()).isEqualTo(new Position());
    }
}
