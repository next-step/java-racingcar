package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarTest {

    @DisplayName("자동차는 Engine이 움직일 수 있으면 움직이고 그렇지 않으면 움직이지 않는다")
    @CsvSource({"true,1", "false,0"})
    @ParameterizedTest
    void moveCar(boolean engineOutput, int distance) {
        //given
        Car car = new Car();
        Engine engine = () -> engineOutput;

        //when
        int location = car.move(engine);

        //then
        assertThat(location).isEqualTo(distance);
    }

}
