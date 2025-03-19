package step4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import step4.racing.ExtendCar;

public class ExtendCarTest {

    @Test
    void 각_자동차에_이름을_부여할_수_있다() {
        ExtendCar extendCar = new ExtendCar("pobi");
        assertThat(extendCar.name()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름은_5자를_초과할수없다() {
        ExtendCar extendCar = new ExtendCar("qwlkdmqlwkmdlqkmwd");
        assertThat(extendCar.name()).isEqualTo("qwlkd");
        assertThat(extendCar.name().length()).isEqualTo(5);
    }
}
