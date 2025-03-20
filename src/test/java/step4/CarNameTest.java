package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {

    @Test
    void createCarName() {
        CarName carName = new CarName("1");
        assertThat(carName.getCarName()).isEqualTo("1");
    }
}
