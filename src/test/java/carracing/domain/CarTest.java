package carracing.domain;

import carracing.service.dto.RacingScores;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    @DisplayName("Engine 클래스 - 랜덤값이 4 이상이면 반드시 움직인다")
    public void engine_move(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
           @Override
           public int nextInt(int bound) {
               return testParam;
           }
        });

        // when then
        assertThat(engine.drive()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, 0, -1, -2})
    @DisplayName("Engine 클래스 - 랜덤값이 4 미만이면 반드시 멈춘다")
    public void engine_stop(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
            @Override
            public int nextInt(int bound) {
                return testParam;
            }
        });

        // when then
        assertThat(engine.drive()).isEqualTo(0);
    }

    @Test
    @DisplayName("Cars 생성 - 자동차 등록 수는 최소 한 대 이상이어야 함")
    public void cars() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Cars(0) )
                .withMessageMatching("자동차 등록수는 최소 한 대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("경기점수 등록 - 참가 자동차 수와 경기스코어 수는 같아야 함")
    void registerRacingScore() {
        // given
        Cars cars = new Cars(5);
        RacingScores racingScores = cars.inquiryRacingScores();

        // when
        cars.driveAll();

        // then
        assertThat(cars.getCarList().size()).isEqualTo(racingScores.getRacingScoreList().size());
    }
}