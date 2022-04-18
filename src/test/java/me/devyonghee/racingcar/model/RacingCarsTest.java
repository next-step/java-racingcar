package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.model.sample.RacingCarSample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("레이싱 자동차들 생성")
class RacingCarsTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> RacingCars.from(
                Collections.singletonList(RacingCarSample.ONLY_MOVE_CAR)));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_emptyCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.from(null));
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.from(Collections.emptyList()));
    }

    @Test
    @DisplayName("주어진 리스트의 크기 반환")
    void size() {
        //given
        List<RacingCar> twoRacingCars = Arrays.asList(RacingCarSample.ONLY_MOVE_CAR, RacingCarSample.ONLY_MOVE_CAR);
        //when, then
        assertThat(RacingCars.from(twoRacingCars).size()).isEqualTo(twoRacingCars.size());
    }
}
