package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {
    @Test
    void carName() {
        CarName carName = new CarName("name");
        assertThat(carName.getName()).isEqualTo("name");
    }

    @Test
    void nameLengthException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarName("longname");
        });
    }
}