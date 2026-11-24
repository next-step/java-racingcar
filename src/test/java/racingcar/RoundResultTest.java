package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class RoundResultTest {

    private static Map<String, Integer> createPositions() {
        Map<String, Integer> positions = new LinkedHashMap<>();
        positions.put("john", 1);
        positions.put("tom", 2);
        return positions;
    }

    @DisplayName("이름과 위치로 생성하면 이름별 위치를 순서대로 알 수 있다. (john 1, tom 2)")
    @Test
    void test_1() {
        assertThat(new RoundResult(createPositions()).getPositions())
                .containsExactly(entry("john", 1), entry("tom", 2));
    }

    @DisplayName("이름과 위치가 같으면 같은 기록이다. (john 1, tom 2 == john 1, tom 2)")
    @Test
    void test_2() {
        assertThat(new RoundResult(createPositions())).isEqualTo(new RoundResult(createPositions()));
    }
}
