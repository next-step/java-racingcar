package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.Car;
import step4.domain.ipnut.InputNames;
import step4.dto.ResponseDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @DisplayName("RacingCarGame 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Cars cars = new Cars("a,b,c");
        Round round = new Round(5);

        // when
        RacingCarGame actualGame = new RacingCarGame(cars, round);
        RacingCarGame expectedGame = new RacingCarGame(cars, round);

        // then
        assertThat(actualGame).isEqualTo(expectedGame);

    }

    @DisplayName("RacingCarGame 다음 라운드 불가능 여부 테스트")
    @Test
    void 다음_라운드_가능() {
        // given
        Cars cars = new Cars("a,b,c");
        Round round = new Round(1);
        RacingCarGame racingCarGame = new RacingCarGame(cars, round);

        // when
        boolean actual = racingCarGame.hasNext();

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("RacingCarGame 다음 라운드 이동 여부 테스트")
    @Test
    void 다음_라운드_이동() {
        // given
        Cars cars = new Cars("a,b,c");
        Round round = new Round(1);
        RacingCarGame racingCarGame = new RacingCarGame(cars, round);

        // when
        racingCarGame.nextRound();
        boolean actual = racingCarGame.hasNext();

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("RacingCarGame 라운드별 ResponseDto 반환 여부 테스트")
    @Test
    void 결과_반환() {
        // given
        Cars cars = new Cars("a,b,c");
        Round round = new Round(1);
        RacingCarGame racingCarGame = new RacingCarGame(cars, round);

        // when
        racingCarGame.nextRound();
        ResponseDto responseDto = racingCarGame.responseDto();

        // then
        assertThat(responseDto).isNotNull();
    }
/*
    @DisplayName("RacingCarGame 우승자 반환 여부 테스트")
    @Test
    void 우승자_반환(){

        // given
        Cars cars = new Cars("a,b,c");
        Round round = new Round(1);
        RacingCarGame racingCarGame = new RacingCarGame(cars, round);

        // when
        Winners winners = racingCarGame.winners();

        // then
        assertThat(winners).isNotNull();
    }
*/
}