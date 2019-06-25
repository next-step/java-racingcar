package racing;

import org.junit.jupiter.api.Test;
import racing.model.CarName;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameTest {

    @Test
    void getName() {
        CarName carName = new CarName("hennry");
        assertThat(carName.getName()).isEqualTo("hennry");
    }
}