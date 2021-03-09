package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 자동차경주 테스트 코드
 *
 * - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈추는 기능
 * - 0~9 사이의 random 값을 추출하여, 4 이상인 경우 전진, 아닌 경우 멈춤
 * - 자동차의 상태를 화면에 출력
 * - 모든 차는 최대 1칸씩 전진
 *
 */
public class RacingTest {
    private Racing racing;


    @ParameterizedTest(name = "초기화 테스트")
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void racingInit(int carCount, int expected) {
        racing = new Racing();
        racing.setUp(carCount);
        assertThat(racing.getCarList().size()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "랜덤 반환(0, 1)에 따른 자동차 별 거리 범위 테스트")
    @CsvSource(value = {"2:2", "2:4", "3:5"}, delimiter = ':')
    void carPoistionBetween(int carCount, int round) {
        racing = new Racing();
        racing.setUp(carCount);

        for(int i=0; i<round; i++) {
            racing.run();
        }

        racing.getCarList().forEach(car -> {
            assertThat(car.getPosition()).isBetween(0, round);
        });
    }

}
