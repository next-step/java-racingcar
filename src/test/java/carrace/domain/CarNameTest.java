package carrace.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    void getResultTest() {
        CarName carName = new CarName("leon");
        assertThat(carName.getResult()).isEqualTo("leon : ");
    }

    @Test
    void validationTest() {
        assertThatThrownBy(() -> {
            new CarName("leon15");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}