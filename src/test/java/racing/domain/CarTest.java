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

    @Test
    @DisplayName("자동차 값 추출 테스트")
    void createCarTest(){
        // Given
        final String name = "lee";
        // When
        Car car = new Car(new Name(name));
        // Then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지 테스트")
    void stayIfNumberIstSmallerThanFour() {
        // Given
        final Car car = new Car(new Name("lee"), new Position(1));
        // When
        car.move(3);
        // Then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 4보다 크면 전진 테스트")
    void moveIfNumberIstGreaterThanAndEqualToFour() {
        // Given
        final Car car = new Car(new Name("lee"), new Position(1));
        // When
        car.move(5);
        // Then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("더 큰 포지션 반환 테스트")
    void getBiggerPositionTest() {
        // Given
        final Car car = new Car(new Name("lee"), new Position(1));
        final Position smallerPosition = new Position(0);
        // When
        Position actual = car.getBiggerPosition(smallerPosition);
        // Then
        assertThat(actual.getNumber()).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("포지션 비교 테스트")
    void isSamePositionTest() {
        // Given
        final Car car = new Car(new Name("lee"), new Position(1));
        final Position smallerPosition = new Position(0);
        // When
        boolean actual = car.isSamePosition(smallerPosition);
        // Then
        assertThat(actual).isFalse();
    }
}
