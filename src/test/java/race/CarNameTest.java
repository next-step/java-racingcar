package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarNameTest {
    @Test
    void 이름이_같으면_동일한_carName으로_취급한다() {
        assertThat(new CarName("a")).isEqualTo(new CarName("a"));
    }

    @ParameterizedTest(name = "{0}은 5자를 넘으므로 CarName 생성 시 오류가 발생한다")
    @ValueSource(strings = {"abcdef", "123456", "simjung"})
    void 차_이름이_5자를_넘으면_IllegalArgumentException이_발생한다(String name) {
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 문자열 {0}과 동일한지 비교할 수 있다")
    @ValueSource(strings = {"a", "bc", "def1"})
    void CarName은_String과_동일한지_비교할_수_있다(String name) {
        assertThat(new CarName(name)).isEqualTo(name);
    }
}
