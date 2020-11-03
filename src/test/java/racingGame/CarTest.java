package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("일반적인 상황의 인스턴스 생성 테스트")
    void createCar() {
        Car car = new Car();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("초깃값이 지정된 인스턴스 생성 테스트")
    void locatedCar() {
        Car car = new Car(1);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("움직임 테스트")
    @ParameterizedTest()
    @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
    void moveTest(int input, int expected) {
        Car car = new Car();
        car.move(input);

        assertThat(car.getPosition()).isEqualTo(expected);
    }

}