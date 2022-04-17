package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    @DisplayName("차량 생성 테스트")
    void circuitTest() {
        int numberOfCars = 3;
        int countOfMoves = 3;
        Circuit circuit = new Circuit(numberOfCars, countOfMoves);
        circuit.startRacing();
        assertThat(numberOfCars).isEqualTo(circuit.getCars().size());
    }

    @Test
    @DisplayName("차량 이동 회수 테스트")
    void carTest() {
        int racingCount = 3;
        Engine engine = new Engine();
        Car car = new Car(engine, racingCount);
        car.racingStart();
        assertThat(racingCount).isEqualTo(car.getMoves().size());
    }
}
