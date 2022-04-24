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
    void circuitTest(String[] carNames, int numberOfRacing) {
        Circuit circuit = new Circuit(carNames, numberOfRacing);
        circuit.startRacing();
        assertThat(carNames.length).isEqualTo(circuit.getCars().size());


        String[] errorMinNumberOfCar = new String[0];
        int errorMinNumberOfMove = 0;
        assertThatThrownBy(() -> new Circuit(errorMinNumberOfCar, numberOfRacing))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Circuit(carNames, errorMinNumberOfMove))
                .isInstanceOf(IllegalArgumentException.class);


        String[] errorMaxNumberOfCar = new String[100];
        int errorMaxNumberOfMove = 100;
        assertThatThrownBy(() -> new Circuit(errorMaxNumberOfCar, numberOfRacing))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Circuit(carNames, errorMaxNumberOfMove))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInputCar() {
        return Stream.of(
                Arguments.of(new String[]{"first", "twice"}, 3)
        );
    }


    @Test
    @DisplayName("차량 이동 회수 테스트")
    void carTest() {
        int moveCount = 3;
        Engine engine = new Engine();
        String carName = "min";
        Car car = new Car(carName, engine, moveCount);
        car.racingStart();
        assertThat(moveCount).isEqualTo(car.getMoves().size());

        int errorMoveCount = 0;
        assertThatThrownBy(() -> new Car(carName, engine, errorMoveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
