package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("각 스텝에 대한 자동차 상태 테스트")
public class SimulationStepTest {
    @DisplayName("한 스텝에서 각기 다른 position에 있는 자동차 상태 확인")
    @Test
    public void getSimulationStepSnapshot() {
        List<Car> cars = new ArrayList();
        cars.add(getCarWithPosition(3));
        cars.add(getCarWithPosition(1));
        cars.add(getCarWithPosition(5));
        SimulationStep step = new SimulationStep(cars);

        String result = step.toString();

        assertThat(result).isEqualTo("---\n-\n-----\n\n");
    }

    private Car getCarWithPosition(int expectedPosition) {
        Car car = new Car();
        for (int i = 0; i < expectedPosition; i++) {
            car.move(9);
        }
        return car;
    }

}