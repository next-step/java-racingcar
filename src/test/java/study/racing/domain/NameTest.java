package study.racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.racing.exception.InvalidCarNameException;

class NameTest {

    @DisplayName("길이 제한 보다 긴 이름이 인자로 들어오면 인스턴스 생성에 실패하는지 검증")
    @ParameterizedTest
    @CsvSource({ "abc, true", "a, true", "aefmakfad, false" })
    void longerThanTest(String name, boolean availableLength) {
        if (availableLength) {
            assertThat(new Name(name).toString()).isEqualTo(name);
        } else {
            assertThatThrownBy(() -> new Name(name)).isInstanceOf(InvalidCarNameException.class);
        }
    }

}
