package study.racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"harry", "jake", "sam", "sj", "w"})
    @DisplayName("5자 이하의 자동차 이름을 자동차에 부여한다")
    void shouldEqualInputName(String input) {
        Name name = new Name(input);

        assertThat(name.getValue()).isEqualTo(input);
        assertThat(name.getValue().length()).isLessThanOrEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"dodeon", "bogeom", "gangjoon"})
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 던진다")
    void shouldThrowExceptionWhenNameIsOverFiveCharacters(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}