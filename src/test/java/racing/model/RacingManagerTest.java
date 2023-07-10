package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.generator.NumberGenerator;
import racing.generator.SpecificNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingManagerTest {

    @DisplayName("simulate 작동 시 정상적으로 반환 되는지 테스트")
    @Test
    void simulateTest() {
        //given
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
