package step4.domain.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RoundTest {

    @DisplayName("클래스가 포함하는 값에 대한 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} - 입력되는 값 : {arguments}")
    @ValueSource(ints = {1, 5, 10})
    void getRound_ValidValue_EqualToExpected(int expected) {

        // given
        Round round = Round.from(expected);

        // when
        int actual = round.getValue();

        // then
        assertThat(actual).isEqualTo(expected);

    }

    @DisplayName("클래스가 포함할 수 없는 값에 대해 IllegalArgumentException 을 반환하는지 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} - 입력되는 값 : {arguments}")
    @ValueSource(ints = {0, -1})
    void getRound_InValidValue_IllegalArgumentExceptionThrown(int expected) {

        // when and then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    assertThat(Round.from(expected));
                }).withMessageMatching("0 이하의 숫자로는 레이싱을 진행할 수 없습니다.");

    }

}