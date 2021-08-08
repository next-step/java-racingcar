package racing_winner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private Car racingCar;

    @Test
    @DisplayName("자동차 글자 수 예외 테스트")
    void setUpException() {
        String name = "crongEx";
        assertThatThrownBy(
                () ->  new Car(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("자동차 생성 테스트")
    void setUp() {
        Car car = new Car("crong");
        assertThat(car.getName()).isEqualTo("crong");
    }

    @ParameterizedTest
    @CsvSource(value = {"3:3", "0:0"}, delimiter = ':')
    @DisplayName("더 멀리 움직인 자동차 거리 확인")
    void findFartherDistance(int baseDistance, int expectedResult) {
        racingCar = new Car("pobi");
        int distance = racingCar.findFartherDistance(baseDistance);
        assertThat(distance).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void move() {
        racingCar = new Car("pobi");
        racingCar.move(() -> true);
        assertThat(racingCar.compareDistance(1)).isTrue();
    }

    @Test
    @DisplayName("자동차 정지 테스트")
    void stop() {
        racingCar = new Car("pobi");
        racingCar.move(() -> false);
        assertThat(racingCar.compareDistance(0)).isTrue();
    }
}