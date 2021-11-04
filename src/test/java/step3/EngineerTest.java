package step3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EngineerTest {

    private static final long GO_COUNT = 3L;
    private static final long CAR_COUNT = 5L;

    @Test
    void makeCar() throws Exception {
        List<Car> cars = Engineer.makeCar(CAR_COUNT, GO_COUNT);

        assertThat(cars.size()).isEqualTo(CAR_COUNT);
        verifyTraceSize(cars);
    }

    private static void verifyTraceSize(List<Car> cars) {
        for (Car car : cars) {
            List<Integer> traces = car.readTrace();
            assertThat(traces.size()).isEqualTo(GO_COUNT);
        }
    }

}
