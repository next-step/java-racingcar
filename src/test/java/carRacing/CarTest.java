package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 객체 테스트")
public class CarTest {
    private Car car;
    private String name = "toby";
    private MovingStrategy movingStrategy;

    @BeforeEach
    void create() {
        movingStrategy = new GreaterThanThreeMovingStrategy();
        car = new Car(name, movingStrategy);
    }
    @Test
    @DisplayName("생성된 자동차의 이름이 있는지 확인")
    void 생성된_자동차_이름_확인(){
        assertThat(car.getCarName()).isEqualTo(name);

    }

    @Test
    @DisplayName("자동차가 거리 기본값을 포함하여 생성되는지 확인")
    void 자동차_거리_생성_확인() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차를 전략에 따라 전진시킬 수 있는지 확인")
    void 자동차_전진_확인() {
        NumberGenerator movableRandomGenerator = new MovableRandomGenerator();

        car.move(movableRandomGenerator.generate());

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이상일 경우 에러 발생 확인")
    void 자동차_이름_5글자_초과_에러_확인() {
        String testName = "abcedf";

        assertThatThrownBy(() -> new Car(testName, movingStrategy)).isInstanceOf(InputMismatchException.class);

    }
}
