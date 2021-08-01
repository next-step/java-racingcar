package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamePolicyImplTest {

    @DisplayName("가능한 이름인지 테스트")
    @ValueSource(strings = {"pobi", "cabib"})
    @ParameterizedTest()
    void legal_name_test(String name) {
        CarNamePolicy carNamePolicy = new CarNamePolicyImpl();
        assertThat(carNamePolicy.isPossibleName(name)).isEqualTo(true);
    }

    @DisplayName("불가능 이름 테스트")
    @ValueSource(strings = {"pobibb", "cabiee"})
    @ParameterizedTest()
    void Illegal_name_test(String name) {
        CarNamePolicy carNamePolicy = new CarNamePolicyImpl();
        assertThat(carNamePolicy.isPossibleName(name)).isEqualTo(false);
    }

}
