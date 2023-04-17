package racing;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RandomMovingStrategyTest {

    @Test
    @DisplayName("랜덤한 값이 정상적으로 나오는지 테스트")
    void raceConditionGenerator_test() {
        List<Boolean> results = Lists.newArrayList();
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(new Random());
        for (int i = 0; i < 10; i++) {
            results.add(randomMovingStrategy.isMovable());
        }

        assertAll(
                () -> assertThat(results).contains(true),
                () -> assertThat(results).contains(false)
        );
    }

    @ParameterizedTest(name = "숫자 4 기준으로 (이상은 true), (미만은 false)로 반환하는지 테스트")
    @CsvSource(value = {"4, 4, true", "4, 5, true", "4, 3, false"})
    void isGreaterThanEqualTest(Integer base, Integer value, boolean expected) {
        boolean result = RandomMovingStrategy.isGreaterThanEqualToBase(base, value);

        assertThat(result).isEqualTo(expected);
    }

    @RepeatedTest(value = 10, name = "0~10 사이 난수 생성 테스트")
    void 난수_생성_테스트() {
        int limit = 10;
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(new Random());
        int randNum = randomMovingStrategy.randPositiveOrZero(limit);

        assertThat(randNum).isBetween(0, 9);
    }
}
