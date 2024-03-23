package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.vo.Name;
import racing.domain.vo.Position;
import racing.util.MovableNumberGenerator;
import racing.util.NonMovableNumberGenerator;
import racing.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    void createCarTest(){
        // Given
        final String name = "lee";
        // When
        Car car = new Car(new Name(name));
        // Then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지")
    @Test
    void stayIfNumberIstSmallerThanFour() {
        // Given
        final Car car = new Car(new Name("lee"), new Position(1));
        final NumberGenerator numberGenerator = new NonMovableNumberGenerator();
        // When
        car.move(numberGenerator.generate());
        // Then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("숫자가 4보다 크면 전진")
    @Test
    void moveIfNumberIstGreaterThanAndEqualToFour() {
        // Given
        final Car car = new Car(new Name("lee"), new Position(1));
        final NumberGenerator numberGenerator = new MovableNumberGenerator();
        // When
        car.move(numberGenerator.generate());
        // Then
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
