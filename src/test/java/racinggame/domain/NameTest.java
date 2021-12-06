package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    @DisplayName("생성자를 통한 이름 필드 초기화가 정상적으로 되었는지 확인합니다.")
    void legalRarameter(String value) {
        Name name = new Name(value);
        assertThat(name.equals(new Name(value))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"여섯글자이름", "abcdef"})
    @DisplayName("5자를 초과하는 이름으로 자동차 객체 생성시 IllegalArgumentException가 발생하는지 확인한다.")
    void illegalRarameter(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        {
                            Name racingCarName = new Name(name);
                        }
                );
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi : tobi", "crong : crang", "honux : choco"}, delimiter = ':')
    @DisplayName("생성자를 통한 이름 필드 초기화가 비정상적으로 되었는지 확인합니다.")
    void illegalRarameter(String initialCarNames, String compareName) {
        Name name = new Name(initialCarNames);
        assertThat(name.equals(new Name(compareName))).isFalse();
    }
}
