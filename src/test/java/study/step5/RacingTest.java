package study.step5;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingTest {
    private Racing racing;

    @ParameterizedTest(name = "초기화 테스트")
    @CsvSource(value = {"test:1", "test1,test2:2", "test1,test2,test3:3"}, delimiter = ':')
    void racingInit(String input, int expected) {
        String[] names = input.split(",");
        racing = new Racing();
        racing.setUp(names);
        assertThat(racing.getCarList().size()).isEqualTo(expected);
    }

}
