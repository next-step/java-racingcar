package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceRequestTest {

    @Test
    void RaceRequest생성할때_성공() {
        // when & then
        assertThatNoException().isThrownBy(() -> new RaceRequest("name", "5"));
    }

    @Test
    void names파싱할때_성공() {
        // given
        final String names = "pobi,crong,honux";

        // when
        final RaceRequest raceRequest = new RaceRequest(names, "5");

        // then
        assertThat(raceRequest.getNames()).isEqualTo(names.split(","));
    }

    @Test
    void null인names파싱할때_실패_RuntimeException발생() {
        // given
        final String names = null;

        // when & then
        assertThatThrownBy(() -> new RaceRequest(names, "5")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void totalRound파싱할때_성공() {
        // given
        final String totalRound = "5";

        // when
        final RaceRequest raceRequest = new RaceRequest("pobi,crong,honux", totalRound);

        // then
        assertThat(raceRequest.getTotalRound()).isEqualTo(Integer.parseInt(totalRound));
    }

    @Test
    void null또는빈문자열인totalRound파싱할때_실패_RuntimeException발생() {
        // given
        final String totalRound1 = null;
        final String totalRound2 = "";

        // when & then
        assertThatThrownBy(() -> new RaceRequest("a,b,c", totalRound1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new RaceRequest("a,b,c", totalRound2)).isInstanceOf(RuntimeException.class);
    }
}
