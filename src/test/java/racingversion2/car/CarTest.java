package racingversion2.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("랜덤값이 4미만일 때 자동차는 움직이지 않는다.")
    void notMove(int random){
        Car car = new Car(CarName.of("jaden"), new Position());
        car.move(random);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    @DisplayName("랜덤값이 4이상일 때 자동차는 움직이지 않는다.")
    void move(int random){
        Car car = new Car(CarName.of("jaden"), new Position());
        car.move(random);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}