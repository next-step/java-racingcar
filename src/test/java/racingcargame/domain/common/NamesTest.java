package racingcargame.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("이름들")
class NamesTest {

    @DisplayName("[성공] 추가")
    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux,hyune")
    public void add(String nameString) {
        // given

        // when
        Names names = new Names(nameString, ",");

        // then
        assertThat(names.getNames().size()).isEqualTo(4);
    }
}
