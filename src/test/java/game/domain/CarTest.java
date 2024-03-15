package game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("toString 테스트")
    void to_string_test(){
        String result = new Car("test", 5).toString();
        assertThat(result).isEqualTo("test : -----");
    }
}
