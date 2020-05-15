package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.car.Car;
import racinggame.domain.result.CarSnapshot;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarTest {

    @DisplayName("자동차는 Engine이 true이면 이동하고, 그렇지 않으면 이동하지 않는다")
    @CsvSource({"true,1", "false,0"})
    @ParameterizedTest
    void moveCar(boolean engineOutput, int expected) {
        //given
        String nameOfCar = "NEXT";
        Car car = new Car(nameOfCar);
        Engine engine = () -> engineOutput;

        //when
        CarSnapshot snapshot = car.move(engine);

        //then
        assertThat(snapshot).isEqualToComparingFieldByField(new CarSnapshot(nameOfCar, expected));
    }

}
