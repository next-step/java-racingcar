package racingcar.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.racing.RacingRound;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRoundTest {

    @DisplayName("RacingRound 가 입력된 값 만큼 반복하는지에 대한 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} / 전체 반복 : {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void hasNext_IntegerValueForLoop_FALSE(int loop){

        // given
        RacingRound racingRound =  RacingRound.from(loop);
        for(int i=0; i < loop; i++){
            racingRound.nextRound();
        }

        // when
        boolean actual = racingRound.hasNext();

        // then
        assertThat(actual).isFalse();
    }


}