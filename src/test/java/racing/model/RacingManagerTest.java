package racing.model;

import org.junit.jupiter.api.Test;
import racing.generator.NumberGenerator;
import racing.generator.SpecificNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingManagerTest {

    @Test
    void simulateTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        NumberGenerator numberGenerator = new SpecificNumberGenerator(9);
        RacingManager manager = new RacingManager(Arrays.asList("test1", "test2"), numberGenerator, 1);

        //when
        SimulationResultDto result = manager.simulate();

        //then
        assertThat(result).isEqualTo(new SimulationResultDto(
                Arrays.asList(
                        Arrays.asList(new CarVO("test1", 1), new CarVO("test2", 1)),
                        Arrays.asList(new CarVO("test1", 2), new CarVO("test2", 2))
                ),
                Arrays.asList(new CarVO("test1", 2), new CarVO("test2", 2))));
    }
}
