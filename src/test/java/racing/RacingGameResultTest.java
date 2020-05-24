package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 게임 결과 클래스 테스트")
class RacingGameResultTest {

    @Test
    @DisplayName("레이싱 결과(position) 테스트")
    void racingResultTest() {
        List<Integer> positionList = new ArrayList<>();
        positionList.add(1);
        positionList.add(2);
        positionList.add(3);

        RacingGameResult result = new RacingGameResult();
        result.addResult(positionList);

        for (int i = 0; i< positionList.size(); i++) {
            List<Integer> round1Position = result.getAllRoundCarsPosition().get(0);
            assertThat(positionList.get(i)).isEqualTo(round1Position.get(i));
        }
    }
}