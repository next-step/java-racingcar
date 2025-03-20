package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @Test
    void createCarName() {
        CarName carName = new CarName("1");
        assertThat(carName.getCarName()).isEqualTo("1");
    }

    @Test
    void 이름은_공백일_수_없다() {
        assertThatThrownBy(() -> new CarName("  "))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 이름은_길이가_5를_초과할_수_없다() {
        assertThatThrownBy(() -> new CarName("123456"))
                .isInstanceOf(RuntimeException.class);
    }
}
