package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("입력한 자동차 이름이 정상적인지 확인")
    void 자동차_이름_글자수_확인() {
        assertThat(new CarName("car1").getCarName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("입력한 자동차 이름이 5자일 경우 정상적인지 확인")
    void 자동차_이름_5자_확인() {
        assertThat(new CarName("car11").getCarName()).isEqualTo("car11");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 에러발생")
    void 자동차_이름_글자수_초과() {
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있다면 공백제거")
    void 차_이름_공백_제거() {
        assertThat(new CarName("c  ar1").getCarName())
                .isEqualTo("car1");
    }

}
