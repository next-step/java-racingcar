package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.strategy.GenerateNumber;
import racinggame.strategy.TestNumber;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 9})
    @DisplayName("성공 - 0에서 9사이의 랜덤 숫자를 반환한다.")
    void success_generate_number(int number) {
        // given
        GenerateNumber generateNumber = new TestNumber(number);

        // when & then
        assertThat(generateNumber.number()).isEqualTo(number);
    }

}
