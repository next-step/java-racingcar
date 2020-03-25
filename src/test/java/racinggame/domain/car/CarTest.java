package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarTest {

    @DisplayName("자동차 이동 거리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "3:0", "4:1", "7:1", "9:1"}, delimiter = ':')
    void moveCar(int randNum, int expect) {
        //given
        Car car = new Car("car");

        //when
        car.moveCar(randNum);

        //then
        assertThat(car.getMoveRange()).isEqualTo(expect);
    }
}
