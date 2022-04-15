package step3.model;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("게임 결과 테스트")
class GameResultTest {

    List<EachTryResult> eachTryResults = new ArrayList<>();
    EachTryResult eachTryResult;

    @BeforeEach
    void setUp() {
        eachTryResult = new EachTryResult(Arrays.asList(0, 0, 1));
        eachTryResults.add(eachTryResult);
    }

    @Test
    void 각_시도의_결과를_입력받아서_게임의_전체_결과에_추가한다() {
        GameResult gameResult = new GameResult();

        gameResult.addTryResult(eachTryResult);

        assertThat(gameResult.getEachTryResults()).containsExactly(eachTryResult);

    }

}