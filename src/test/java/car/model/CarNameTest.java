package car.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    public void 자동차_이름이_최대_길이를_넘어서는_경우_에러_테스트() {
        assertThatThrownBy(() -> new CarName("carnameismaxlength"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void 자동차_이름이_최대_길이를_넘지않는_경우_정상_동작_테스트() {
        CarName carName = new CarName("name");
        assertThat(carName.getName()).isEqualTo("name");
    }
}
