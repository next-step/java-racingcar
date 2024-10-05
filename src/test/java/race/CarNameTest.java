package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    void 생성() {
        CarName carName = new CarName("pobi");

        assertThat(carName).isEqualTo(new CarName("pobi"));
    }
}
