package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    @DisplayName("자동차를 생성한다.")
    void createCar() {
        //given
        Vehicle car = new Car();

        //when & then
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    @DisplayName("4이상의 수 를 넘겨주면 자동차를 한칸 움직인다.")
    void moveCar(int number) {
        //given
        Car car = new Car();

        //when
        car.move(number);

        //then
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("4이하의 수 를 넘겨주면 자동차를 움직이지 않는다.")
    void dontMoveCar(int number) {
        //given
        Car car = new Car();

        //when
        car.move(number);

        //then
        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}
