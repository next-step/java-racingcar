package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 객체 테스트")
public class CarTest {
    private Car car;
    private final String name = "toby";
    private MovingStrategy movingStrategy;

    @BeforeEach
    void create() {
        movingStrategy = new GreaterThanThreeMovingStrategy();
        car = new Car(name, movingStrategy);
    }

    @Test
    @DisplayName("생성된 자동차의 이름이 있는지 확인")
    void 생성된_자동차_이름_확인() {
        assertThat(car.getCarNameForPrint()).isEqualTo(name);

    }

    @Test
    @DisplayName("자동차가 거리 기본값을 포함하여 생성되는지 확인")
    void 자동차_거리_생성_확인() {
        assertThat(car.isSameDistance(0)).isTrue();
    }

    @Test
    @DisplayName("자동차를 전략에 따라 전진시킬 수 있는지 확인")
    void 자동차_전진_확인() {
        NumberGenerator movableRandomGenerator = new MovableRandomGenerator();

        car.move(movableRandomGenerator.generate());

        assertThat(car.isSameDistance(1)).isTrue();
    }

}
