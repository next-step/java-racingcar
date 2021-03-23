package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 랜덤값 4 이상 나올 경우 이동 확인")
    @ValueSource(ints = { 5, 10, 500})
    public void moveCar(int randomValue){
        Car car = new Car("name");
        car.move(randomValue);

        assertThat(car.isMoving()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 랜덤값 3이하 나올 경우 이동 확인")
    @ValueSource(ints = { 3, 1, 2})
    public void notMoveCar(int randomValue){
        Car car = new Car("name");
        car.move(randomValue);

        assertThat(car.isMoving()).isFalse();
    }


}
