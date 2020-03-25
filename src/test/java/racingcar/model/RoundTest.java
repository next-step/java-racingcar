package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {
    private int tryCount = 3;

    private Round round;

    @BeforeEach
    void setUp() {
        round = new Round(tryCount);
    }

    @DisplayName("다음 라운드로 넘어 갈 수 있다.")
    @Test
    void next() {
        // given
        final Round expect = new Round(2);

        // when
        final Round actual = round.next();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getRound()).isEqualTo(expect);
    }

    @DisplayName("라운드 종료 확인을 성공한다.")
    @Test
    void isEnd() {
        // given
        for (int i = 0; i < tryCount; i++) {
            round = round.next();
        }

        // when
        final boolean actual = round.isEnd();

        // then
        assertThat(actual).isNotNull();
        assertThat(actual).isTrue();
    }
}