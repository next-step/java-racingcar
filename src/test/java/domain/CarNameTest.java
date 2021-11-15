package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름 생성")
    public void createCarName() {
        assertThat(new CarName("abc").value()).isEqualTo("abc");
    }

    @Test
    @DisplayName("자동차 이름 길이가 5자리 초과하면 에러가 발생한다.")
    public void checkNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CarName("abcdef");

            fail("이름길이 초과 에러가 발생해야 한다.");
        });
    }

}
