package racing;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RaceConditionGeneratorTest {

    @Test
    void isForwardableTest() {
        List<Boolean> results = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            results.add(RaceConditionGenerator.isForwardable());
        }

        assertAll(
                () -> assertThat(results).contains(true),
                () -> assertThat(results).contains(false)
        );
    }

    @ParameterizedTest(name = "숫자 4 기준으로 (이상은 true), (미만은 false)로 반환하는지 테스트")
    @CsvSource(value = {"4, 4, true", "4, 5, true", "4, 3, false"})
    void isGreaterThanEqualTest(Integer base, Integer value, boolean expected) {
        boolean result = RaceConditionGenerator.isGreaterThanEqualToBase(base, value);

        assertThat(result).isEqualTo(expected);
    }

    @RepeatedTest(value = 10, name = "0~10 사이 난수 생성 테스트")
    void 난수_생성_테스트() {
        int limit = 10;
        int randNum = RaceConditionGenerator.randPositiveOrZero(limit);

        assertThat(randNum).isBetween(0, 9);
    }
}
