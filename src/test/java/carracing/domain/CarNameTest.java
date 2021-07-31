package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    public void invalidCarNameLengthTest() {
        String invalidLengthCarName = "일이삼사오륙";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.of(invalidLengthCarName))
                .withMessageContaining("자동차 이름이 유효하지 않습니다.");
    }

    @ParameterizedTest(name = "자동차 이름은 Null이나 빈 문자열 일 수 없다.")
    @NullAndEmptySource
    public void nullOrEmptyNameFailTest(String nullOrEmpty) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.of(nullOrEmpty))
                .withMessageContaining("자동차 이름이 유효하지 않습니다.");
    }

    @DisplayName("값 객체 캐시 테스트")
    @Test
    public void cacheTest() {
        assertThat(CarName.of("abc") == CarName.of("abc")).isTrue();
        assertThat(CarName.of("abc") == CarName.of("cba")).isFalse();
    }

}