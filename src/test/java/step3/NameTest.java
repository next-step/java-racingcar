package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
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
}
