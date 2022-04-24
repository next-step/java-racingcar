package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @ParameterizedTest
    @MethodSource("provideInputCar")
    void circuitTest(int numberOfCar, int numberOfRacing) {
        Circuit circuit = new Circuit(numberOfCar, numberOfRacing);
        circuit.startRacing();
        assertThat(numberOfCar).isEqualTo(circuit.getCars().size());


        int errorMinNumberOfCar = 0;
        int errorMinNumberOfMove = 0;
        assertThatThrownBy(() -> new Circuit(errorMinNumberOfCar, numberOfRacing))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Circuit(numberOfCar, errorMinNumberOfMove))
                .isInstanceOf(IllegalArgumentException.class);


        int errorMaxNumberOfCar = 100;
        int errorMaxNumberOfMove = 100;
        assertThatThrownBy(() -> new Circuit(errorMaxNumberOfCar, numberOfRacing))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Circuit(numberOfCar, errorMaxNumberOfMove))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInputCar() {
        return Stream.of(
                Arguments.of(3, 3)
        );
    }


    @Test
    @DisplayName("차량 이동 회수 테스트")
    void carTest() {
        int moveCount = 3;
        Engine engine = new Engine();
        Car car = new Car(engine, moveCount);
        car.racingStart();
        assertThat(moveCount).isEqualTo(car.getMoves().size());

        int errorMoveCount = 0;
        assertThatThrownBy(() -> new Car(engine, errorMoveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
