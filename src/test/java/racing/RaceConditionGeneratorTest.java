package racing;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceConditionGeneratorTest {

    @RepeatedTest(value = 10, name = "0~10 사이 난수 생성 테스트")
    void 난수_생성_테스트() {

        int limit = 10;
        int randNum = RaceConditionGenerator.randPositiveOrZero(limit);

        assertThat(randNum).isBetween(0, 9);
    }
}
