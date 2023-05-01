package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class NameTest {

    @DisplayName("자동차이름 길이 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"invalidCar"})
    void 자동차이름_5자초과(String input) {

        assertThatIllegalStateException()
                .isThrownBy(() -> new Car(input, () -> true))
                .withMessageMatching("차 이름은 5글자를 초과할 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("자동차이름 공백 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void 자동차이름_공백_확인(String input) {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Car(input, () -> true))
                .withMessageMatching("차 이름은 공백일 수 없습니다.");
    }
}
