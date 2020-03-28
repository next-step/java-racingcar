package RacingCar;

import RacingCar.model.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class RacingGameTest {

    private static final List<String> CAR_NAMES = Arrays.asList("a", "b", "c");
    private static final int STAGE_COUNT = 5;
    private static final int THRESHOLD = 4;


    @DisplayName("결과 테스트")
    @Test
    void start() {
        List<Result> results = RacingGame.getInstance().start(CAR_NAMES, STAGE_COUNT);
        assertThat(results.size()).isEqualTo(STAGE_COUNT);
    }


    @DisplayName("랜덤 이동 값 테스트 4이하면 false")
    @Test
    void isMovable() {
        boolean isMove = RacingGame.isMovable(THRESHOLD - 1);
        System.out.println(isMove);
        assertThat(isMove).isFalse();
    }


    @DisplayName("최대 이동값 테스트")
    @Test
    void getMax() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        ResultView resultView = new ResultView();
        int max = resultView.getMaxMove(map);
        assertThat(max).isEqualTo(3);
    }

    @DisplayName("이동한 거리만큼 - 문자가 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void getMoveString(int input) {
        ResultView resultView = new ResultView();
        String string = resultView.getMoveString(input);
        assertThat(string.length()).isEqualTo(input);
    }
}

