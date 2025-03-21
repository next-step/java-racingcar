package step4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import step4.racing.NameCar;

public class NameCarTest {

    @Test
    void 각_자동차에_이름을_부여할_수_있다() {
        NameCar nameCar = new NameCar("pobi");
        assertThat(nameCar.name()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름은_5자를_초과할수없다() {
        NameCar nameCar = new NameCar("qwlkdmqlwkmdlqkmwd");
        assertThat(nameCar.name()).isEqualTo("qwlkd");
        assertThat(nameCar.name().length()).isEqualTo(5);
    }
}
