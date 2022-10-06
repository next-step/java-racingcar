package game.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    void 자동차_이름_생성() {
        Assertions.assertThat(new CarName("myCar")).isEqualTo(new CarName("myCar"));
    }

    @Test
    void 자동차_이름_생성_5자_초과() {
        Assertions.assertThatThrownBy(() -> new CarName("다섯자넘었다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
