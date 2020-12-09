package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @DisplayName("자동차 이름이 입력값으로 생성되는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"BMW", "Audi"})
    void createNameTest(String name) {
        CarName carName = new CarName(name);

        assertThat(carName.get()).isEqualTo(name);
    }

    @DisplayName("자동차 이름 문자열 길이 초과 예외처리를 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"HYUNDAI", "Yonggu"})
    void lengthFiveValidTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 이름 빈 문자열 예외처리를 확인한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyValidTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage("자동차 이름의 문자열은 필수값입니다.");
    }
}
