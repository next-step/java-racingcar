package racingcar.domain.car;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerGeneratorTest {

    @Test
    public void power값_확인() {
        PowerGenerator powerGenerator = new PowerGenerator();

        int result = powerGenerator.getPower(5);
        assertThat(result).isEqualTo(1);

        result = powerGenerator.getPower(2);
        assertThat(result).isEqualTo(0);
    }
}