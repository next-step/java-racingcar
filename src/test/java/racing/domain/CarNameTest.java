package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {
    @DisplayName("생성 - 정상적인 이름")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void create(String name) {
        //when
        CarName carName = new CarName(name);

        //then
        assertThat(carName).isNotNull();
    }

    @DisplayName("생성 - 비정상적인 이름")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void create_exception(String name) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage("잘못된 이름입니다.");
    }
}
