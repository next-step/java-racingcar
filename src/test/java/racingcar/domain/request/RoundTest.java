package racingcar.domain.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @DisplayName("클래스가 포함하는 값에 대한 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} / 전체 반복 : {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void getRoundTest(int expected) {

        // given
        Round round = Round.from(expected);

        // when
        int actual = round.getValue();

        // them
        assertThat(actual).isEqualTo(expected);

    }

}