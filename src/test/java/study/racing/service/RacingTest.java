package study.racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingTest {

    @DisplayName("레이싱게임 참가차량수와 시도횟수를 넣고 값이 정상적으로 거리이동이 설정되는지 테스트.")
    @Test
    void 차량수와게임횟수설정테스트() {
        Racing racing = new Racing();
        racing.setGameCount("3","1");

        assertThat(racing.getCars()).hasSize(3);
        assertThat(racing.getCars()).extracting(car -> car.getDistance().getMove()).anyMatch(move -> move < 2);
    }

    @DisplayName("거리수만큼 이동경로가 표현되는지 체크.")
    @Test
    void drawDisplay() {
        Racing racing = new Racing();
        racing.setGameCount("3","5");
    }

    @DisplayName("입력값이 null이거나 빈값인 경우 검증하여 IllegalArgumentException이 발생하는지 테스트.")
    @ParameterizedTest
    @CsvSource(value = {"1,",",1"})
    void name(String carCount, String roundCount) {
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Racing racing = new Racing();
                    racing.setGameCount(carCount,roundCount);
                });
    }

}