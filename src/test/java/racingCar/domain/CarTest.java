package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 전진, 정지 후 거리 확인")
    @Test
    void testCreateCar() {
        Car car = new Car(new Name("호랑이"));
        assertThat(car.getCarDistance()).isEqualTo(0);
        car = car.move(true);
        assertThat(car.getCarDistance()).isEqualTo(1);
        car = car.move(false);
        assertThat(car.getCarDistance()).isEqualTo(1);
    }

    @DisplayName("자동차 이름 지정")
    @ParameterizedTest
    @ValueSource(strings = {"원숭이", "코끼리", "푸마", "불독"})
    void testSetCarName(String input) {
        Car car = new Car(new Name(input));
        assertThat(car.getCarName()).isEqualTo(input);
    }

    @DisplayName("자동차간 거리 비교 테스트")
    @Test
    void testIsSameCarDistance() {
        assertThat(new Car(new Name("ABC"), new Distance(5)).isSameCarDistance(5)).isTrue();
        assertThat(new Car(new Name("ABC"), new Distance(3)).isSameCarDistance(5)).isFalse();
    }

}