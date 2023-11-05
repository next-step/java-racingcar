package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 객체 테스트")
public class CarTest {
    private Car car;

    @BeforeEach
    void create() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차가 거리 기본값을 포함하여 생성되는지 확인")
    void 자동차_생성() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차를 전략에 따라 전진시킬 수 있는지 확인")
    void 자동차_전진_확인() {
        NumberGenerator movableRandomGenerator = new MovableRandomGenerator();
        car.move(movableRandomGenerator.generate());
        assertThat(car.getDistance()).isEqualTo(1);

    }
}
