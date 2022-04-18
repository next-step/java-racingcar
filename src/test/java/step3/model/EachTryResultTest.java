package step3.model;


import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("각 시도 결과 테스트")
class EachTryResultTest {

    Map<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("가", 1);
        map.put("나", 2);
        map.put("다", 2);
    }

    @Test
    void 문자열_과_정수형_맵을_입력_받아서_1회_시도의_결과를_기록하는_객체를_생성한다() {
        EachTryResult eachTryResult = new EachTryResult(map);
        assertThat(eachTryResult.getMoveCountEach()).isEqualTo(map);
    }

    @Test
    void 각_회차까지의_결과의_우승자의_이름을_구한다() {
        EachTryResult eachTryResult = new EachTryResult(map);
        assertThat(eachTryResult.getWinnerNames()).containsExactly("나", "다");
    }

}