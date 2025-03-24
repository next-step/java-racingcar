package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {
    @DisplayName("자동차 이름 제약")
    @Test
    void car_name() {
        Name name = new Name("pobi");
        assertThat(name).extracting("value").isEqualTo("pobi");
    }
}
