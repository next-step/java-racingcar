package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FowardPolicyImplTest {

    @DisplayName("4이상인 경우 전진 테스트")
    @CsvSource(value = {"1,false","4,true"})
    @ParameterizedTest
    void 전진_테스트(int number, boolean expect) {
        FowardPolicyImpl fowardPolicy = new FowardPolicyImpl();
        assertThat(fowardPolicy.isMovableNumber(number)).isEqualTo(expect);
    }

}
