package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ForwardPolicyImplTest {

    @DisplayName("4이상인 경우 전진 테스트")
    @CsvSource(value = {"1,false", "4,true"})
    @ParameterizedTest
    void 전진_테스트(int number, boolean expect) {
        ForwardPolicyImpl fowardPolicy = new ForwardPolicyImpl();
        assertThat(fowardPolicy.isMovableNumber(number)).isEqualTo(expect);
    }

}
