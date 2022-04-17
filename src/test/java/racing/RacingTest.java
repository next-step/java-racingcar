package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @Test
    @DisplayName("차량 생성 테스트")
    void circuitTest() {
        int numberOfCars = 3;
        int numberOfMoves = 3;
        Circuit circuit = new Circuit(numberOfCars, numberOfMoves);
        circuit.startRacing();
        assertThat(numberOfCars).isEqualTo(circuit.getCars().size());


        int errorMinNumberOfCar = 0;
        int errorMinNumberOfMove = 0;
        assertThatThrownBy(() -> new Circuit(errorMinNumberOfCar, numberOfMoves))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Circuit(numberOfCars, errorMinNumberOfMove))
                .isInstanceOf(IllegalArgumentException.class);


        int errorMaxNumberOfCar = 100;
        int errorMaxNumberOfMove = 100;
        assertThatThrownBy(() -> new Circuit(errorMaxNumberOfCar, numberOfMoves))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Circuit(numberOfCars, errorMaxNumberOfMove))
                .isInstanceOf(IllegalArgumentException.class);
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
