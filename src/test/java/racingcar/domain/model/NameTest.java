package racingcar.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.NameNullPointerException;
import racingcar.domain.exception.NameOutOfRangeException;

public class NameTest {

    @ParameterizedTest
    @DisplayName("이름이 정상적으로 생성되었는지 확인")
    @ValueSource(strings = {"kim", "dong", "hyo", "acorn"})
    void createNameSuccess(String name) {
        assertThat(Name.from(name)).isEqualTo(Name.from(name));
    }

    @ParameterizedTest
    @DisplayName("이름이 null 혹은 빈 값일 시 예외처리")
    @NullAndEmptySource
    void createNameNullAndEmptyException(String name) {
        assertThatExceptionOfType(NameNullPointerException.class)
            .isThrownBy(() -> Name.from(name));
    }

    @ParameterizedTest
    @DisplayName("이름길이가 5초과일 시 예외처리")
    @ValueSource(strings = {"kimkim", "dongdong", "hyohyohyo"})
    void createNameRangeException(String name) {
        assertThatExceptionOfType(NameOutOfRangeException.class)
            .isThrownBy(() -> Name.from(name));
    }


}
