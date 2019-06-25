package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    void getName() {
        CarName carName = new CarName("hennry");
        assertThat(carName.getName()).isEqualTo("hennry");
    }
}