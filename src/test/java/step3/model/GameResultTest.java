package step3.model;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("게임 결과 테스트")
class GameResultTest {

    Map<String, Integer> map;
    EachTryResult eachTryResult;
    List<EachTryResult> eachTryResults;


    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("가", 1);
        map.put("나", 2);
        map.put("다", 2);

        eachTryResult = new EachTryResult(map);

        eachTryResults = new ArrayList<>();
        eachTryResults.add(eachTryResult);
    }

    @Test
    void 각_시도의_결과를_입력받아서_게임의_전체_결과에_추가한다() {
        GameResult gameResult = new GameResult();

        gameResult.addTryResult(eachTryResult);

        assertThat(gameResult.getEachTryResults()).containsExactly(eachTryResult);
    }

    @Test
    void 게임의_우승자를_구한다() {
        GameResult gameResult = new GameResult();
        gameResult.addTryResult(eachTryResult);

        gameResult.updateWinner();

        assertThat(gameResult.getWinnerNames()).containsExactly("나", "다");
    }

}