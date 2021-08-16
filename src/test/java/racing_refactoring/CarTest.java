package racing_refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing_refactoring.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private Car car;

    @BeforeEach
    void setRacingCar(){
        car = new Car("pobi", 0);
    }

    @Test
    @DisplayName("Car 정상 생성 테스트")
    void setCar(){
        assertThat(car.toString()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("Car 생성 예외 테스트")
    void setCarException(){
        assertThatThrownBy(
                () -> new Car("carException", 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Car 전진 테스트")
    void move() {
        car.move(() -> true);
        assertThat(car.compareDistance(1)).isTrue();
    }
    @Test
    @DisplayName("Car 정지 테스트")
    void stop() {
        car.move(() -> false);
        assertThat(car.compareDistance(0)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "0,0"}, delimiter = ',')
    @DisplayName("자동차 거리 비교 테스트")
    void findFartherDistance(int baseDistance, int expectedResult) {
        int distance = car.findFartherDistance(baseDistance);
        assertThat(distance).isEqualTo(expectedResult);
    }

}
