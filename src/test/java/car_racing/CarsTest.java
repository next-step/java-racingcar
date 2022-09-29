package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName(value = "0이하는 생성 불가능하다")
    public void cars_생성() {
        Assertions.assertThatThrownBy(() -> {
            new Cars(-1, new RandomMovableStrategy());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
