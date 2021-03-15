package step5;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;

public class CarNameTest {


    @DisplayName("5글자 초과")
    @Test
    void 이상() {
        assertThat(new Car("4글자#").isExceedWord("5글자##")).isEqualTo(true);
    }

    @DisplayName("5글자 미만")
    @Test
    void 미만() {
        assertThat(new Car("5글자##").isExceedWord("4글자#")).isEqualTo(false);
    }
}
