package race;

import org.junit.jupiter.api.Test;
import race.domain.CarState;

import static org.assertj.core.api.Assertions.assertThat;

public class CarStateTest {
    @Test
    void 더_큰_상태값_반환() {
        // given
        int currentMaxState = 4;
        int currentCarState = 5;
        CarState state = new CarState(currentCarState);

        // when
        int result = state.max(currentMaxState);

        // then
        assertThat(result).isEqualTo(currentCarState);
    }

    @Test
    void 상태값_같은지_검증() {
        // given
        int currentCarState = 5;
        int inputState = 5;
        CarState state = new CarState(currentCarState);

        // when
        boolean result = state.isEqualWith(inputState);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 상태값_표현용_마커_문자열_생성_검증() {
        // given
        int currentCarState = 5;
        CarState state = new CarState(currentCarState);

        // when
        String carStateMarkers = state.makeCarStateMarkers();

        // then
        assertThat(carStateMarkers).isEqualTo("-----");
    }

    @Test
    void 전진() {
        // given
        CarState state = new CarState();

        // when
        state.moveForward();

        // then
        assertThat(state.isEqualWith(1)).isTrue();
    }
}
