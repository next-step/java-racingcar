package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 랜덤값 4 이상 입력시 이동")
    @ValueSource(ints = { 5, 10, 500})
    public void moveCarTest(int data){
        Car car = new Car();
        car.go(data);

        assertThat(car.getGoCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차 랜덤값 3 이하 입력시 이동 안함")
    @ValueSource(ints = { 3, -1, 0, 2})
    public void notMoveCarTest(int data){
        Car car = new Car();
        car.go(data);

        assertThat(car.getGoCount()).isEqualTo(0);
    }
}
