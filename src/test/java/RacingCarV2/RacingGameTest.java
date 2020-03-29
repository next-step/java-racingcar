package RacingCarV2;

import RacingCarV2.domain.RacingGame;
import RacingCarV2.model.StageResult;
import RacingCarV2.view.StageView;
import RacingCarV2.view.WinnerView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameTest {

    private static final List<String> CAR_NAMES = Arrays.asList("a", "b", "c");
    private static final int STAGE_COUNT = 5;

    private RacingGame racingGame;
    private List<StageResult> stageResults;

    @BeforeEach
    void setup() {
        racingGame = new RacingGame();
        stageResults = racingGame.start(CAR_NAMES, STAGE_COUNT);
    }

    @DisplayName("게임 결과 테스트")
    @Test
    void start() {

        RacingGame racingGame = new RacingGame();
        List<StageResult> stageResults = racingGame.start(CAR_NAMES, STAGE_COUNT);
        assertThat(stageResults.size()).isEqualTo(STAGE_COUNT);

    }

    @DisplayName("이동한 거리만큼 - 문자가 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void getMoveString(int input) {
        StageView stageView = new StageView();
        String string = stageView.getMoveString(input);
        assertThat(string.length()).isEqualTo(input);
    }

    @DisplayName("3 이하는 이동 불가")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isMovable(int input) {
        RacingGame racingGame = new RacingGame();
        boolean isMovable = racingGame.isMovable(input);
        assertFalse(isMovable);
    }

    @DisplayName("가장 큰 이동값 확인")
    @Test
    void getWinners() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        WinnerView winnerView = new WinnerView(stageResults);
        int max = winnerView.getMaxPosition(map);
        assertTrue(max == 3);


    }
}
