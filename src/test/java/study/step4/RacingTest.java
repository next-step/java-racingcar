package study.step4;

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

    @ParameterizedTest(name = "랜덤 반환(0, 1)에 따른 자동차 별 거리 범위 테스트")
    @CsvSource(value = {"test1,test2:2", "test1,test2:4", "test1,test2,test3:5"}, delimiter = ':')
    void carPoistionBetween(String input, int round) {
        racing = new Racing();
        String[] names = input.split(",");
        racing.setUp(names);

        for(int i=0; i<round; i++) {
            racing.run();
        }

        racing.getCarList().forEach(car -> {
            assertThat(car.getPosition()).isBetween(0, round);
        });
    }
}
