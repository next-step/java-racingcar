package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @ParameterizedTest
    @MethodSource("getRacingCarName")
    @DisplayName("이름을 가지는 레이싱카 생성 테스트")
    void 이름을_가지는_레이싱카_생성_테스트(String carName) {
        RacingCar racingCar = RacingCar.from(carName);

        assertThat(racingCar.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @MethodSource("getRacingCarName")
    @DisplayName("레이싱카 이동 테스트")
    void 레이싱카_이동_테스트(String carName) {
        RacingCar racingCar = RacingCar.from(carName);

        racingCar.move(() -> true);

        assertThat(racingCar.getCurrentLocation()).isEqualTo(1);
    }

    static Stream<String> getRacingCarName() {
        return Stream.of("pobi", "gang", "gwal", "gwak");
    }

}