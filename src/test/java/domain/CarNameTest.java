package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    private CarName carName;

    @BeforeEach
    public void setup(){
        carName = new CarName("abc");
    }

    @Test
    @DisplayName("자동차 이름 생성(값 비교)")
    public void checkCarName(){
        assertThat(carName.value()).isEqualTo("abc");
    }

    @Test
    @DisplayName("자동차 이름 생성(객체의 동등성 비교)")
    public void createCarName() {
        assertThat(carName).isEqualTo(new CarName("abc"));
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
