package carracing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName(value = "0 미만은 생성 불가능하다")
    void cars_생성() {
        Assertions.assertThatThrownBy(() -> {
            new Cars(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
