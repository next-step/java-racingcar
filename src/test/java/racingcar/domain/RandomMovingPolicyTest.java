package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovingPolicyTest {

    @DisplayName("랜덤값이 4이상인 경우만 1만큼 이동한다")
    @ParameterizedTest
    @CsvSource(value = {
            "0,0",
            "3,0",
            "4,1",
            "10,1"
    })
    void nextStep(Integer randomNumber, Integer expected) {
        RandomMovingPolicy randomMovingPolicy = new RandomMovingPolicy(new RandomGenerator() {
            @Override
            public Integer randomNumber() {
                return randomNumber;
            }
        });

        assertThat(randomMovingPolicy.nextStep()).isEqualTo(expected);
    }
}