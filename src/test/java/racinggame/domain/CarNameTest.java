package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    void create() {
        CarName car = new CarName("car1");
        assertThat(car).isEqualTo(new CarName("car1"));
    }

    @Test
    void 유효하지않은_이름() {
        assertThatThrownBy(() -> new CarName("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}