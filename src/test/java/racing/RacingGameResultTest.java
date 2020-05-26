package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingGameResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 게임 결과 클래스 테스트")
class RacingGameResultTest {

    @Test
    @DisplayName("자동차 3대 각각의 위치를 RacingGameResult에서 받았을때 똑같은 결과가 나오는지 테스트")
    void racingResultTest() {
        List<Integer> positionList = Arrays.asList(1, 2, 3);

        RacingGameResult result = new RacingGameResult();
        result.addResult(positionList);

        int carCount = positionList.size();
        for (int i = 0; i< carCount; i++) {
            List<Integer> round1Position = result.getAllRoundCarsPosition().get(0);
            assertThat(positionList.get(i)).isEqualTo(round1Position.get(i));
        }
    }
}