package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.ipnut.InputRound;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    private final int ROUND_COUNT = 1;

    @DisplayName("Round 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        InputRound inputRound = new InputRound(ROUND_COUNT);

        // when
        Round round = new Round(inputRound);

        // then
        assertThat(round).isNotNull();

    }

    @DisplayName("Round 인스턴스에 부적절한 값 주입시 예외처리 발생 여부 테스트")
    @Test
    void 검증() {
        // given
        int invalidValue = -1;

        // when and then
        assertThatThrownBy(() -> {
            new Round(invalidValue);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 사용했습니다.");

    }

    @DisplayName("Round 인스턴스가 라운드 시작 여부 테스트")
    @Test
    void 시작() {
        // given
        InputRound inputRound = new InputRound(ROUND_COUNT);
        Round round = new Round(inputRound);

        // when
        boolean actual = round.hasNext();

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("Round 인스턴스 라운드 감소 여부 테스트")
    @Test
    void 감소() {
        // given
        InputRound inputRound = new InputRound(ROUND_COUNT);
        Round round = new Round(inputRound);

        // when
        round.nextRound();
        boolean actual = round.hasNext();

        // then
        assertThat(actual).isFalse();
    }

}