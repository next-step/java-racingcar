package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차의_getCondifionNumber_메소드의_값은_0에서_9사이의_값이다() {
        Car car = new Car();

        int conditionNumber = car.getConditionNumber();

        assertThat(conditionNumber).isBetween(0, 9);
    }
}
