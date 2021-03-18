package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @DisplayName("RacingCarGame 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Cars cars = new Cars("a,b,c");
        Round round = new Round(5);

        // when
        RacingCarGame racingCarGame = new RacingCarGame(cars, round);

        // then
        assertThat(racingCarGame).isNotNull();

    }
}