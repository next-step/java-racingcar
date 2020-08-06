package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarGroupTest {
    CarGroup carGroup;

    @ParameterizedTest
    @ValueSource(strings = {"5", "3", "4", "7"})
    public void carGroupCount(int count) {
        carGroup = new CarGroup(count);
        Assertions.assertThat(carGroup.getCarList().size()).isEqualTo(count);
    }
}
