package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("이름 정상 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"유재석",  "강호동", "나얼"})
    void 이름_정상(String param) {
        assertThat(new Name(param)).isEqualTo(new Name(param));
    }

    @DisplayName("이름 1글자 이하 5글자 이상인 경우 IllegalArgumentException 처리")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"유퀴즈온더블록",  ""})
    void 이름_1글자_이하_5글자_이상인_경우(String param) {
        assertThatThrownBy(() -> {
            assertThat(new Name(param));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
