package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    void test_car_name_equals() {
        assertThat(new CarName("abc")).isEqualTo(new CarName("abc"));
    }

    @Test
    void test_car_name_to_string() {
        assertThat(new CarName("abc").toString()).isEqualTo("abc");
    }

    @Test
    void test_car_name_with_long_length() {
        assertThatThrownBy(() -> new CarName("long-name"))
                .isInstanceOf(CarNameTooLongException.class);
    }
}
