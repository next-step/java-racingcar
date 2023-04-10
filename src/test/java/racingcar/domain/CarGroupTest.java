package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void create(String value) {
        Positive carSize = Positive.create(value);
        CarGroup carGroup = CarGroup.create(carSize);

        assertThat(carGroup).isNotNull();
    }
}
