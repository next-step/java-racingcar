package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"5chars", "5글자이상"})
    void 자동차_이름은_5자를_초과할_수_없다(String input) {
        assertThatThrownBy(() -> new Cars(new String[]{input}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자까지 가능합니다. : "+ input);
    }
}