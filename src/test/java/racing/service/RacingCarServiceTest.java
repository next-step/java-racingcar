package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {

    @Test
    @DisplayName("경주 후 자동차 이동 확인")
    void randomPlay() {
        StringBuffer racingSign = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            racingSign = RacingCarService.randomPlay(racingSign);
        }
        assertThat(racingSign).isNotBlank();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 12, 3})
    @DisplayName("자동차 경주 초기 HashMap 생성 테스트")
    void initialRacingCar(int racingCar) {
        HashMap<Integer, StringBuffer> car = RacingCarService.initialRacingCar(racingCar);
        assertThat(car.size()).isEqualTo(racingCar);
    }

}