package racing;

import org.junit.jupiter.api.Test;
import racing.model.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {

    @Test
    void getName() {
        CarName carName = new CarName("hennry");
        assertThat(carName.getName()).isEqualTo("hennry");
    }

    @Test
    void throwExceptionWhenNameEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(null));
    }
}