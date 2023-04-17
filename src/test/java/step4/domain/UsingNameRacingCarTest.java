package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UsingNameRacingCarTest {

    @ParameterizedTest
    @MethodSource("getRacingCarName")
    @DisplayName("이름을 가지는 레이싱카 생성 테스트")
    void 이름을_가지는_레이싱카_생성_테스트(String carName) {
        UsingNameRacingCar usingNameRacingCar = UsingNameRacingCar.of(carName);

        assertThat(usingNameRacingCar.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null or 빈값 일 경우 예외를 던진다")
    void null_or_빈값_일_경우_예외를_던진다(String carName) {

        assertThatIllegalArgumentException().isThrownBy(() -> UsingNameRacingCar.of(carName))
                .withMessage("자동차 이름을 입력해주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"getRacingCarName"})
    @DisplayName("5자리 초과할 경우 예외를 던진다")
    void _5자리_초과할_경우_예외를_던진다(String carName) {

        assertThatIllegalArgumentException().isThrownBy(() -> UsingNameRacingCar.of(carName))
                .withMessage("5자를 초과할수 없습니다");
    }

    @ParameterizedTest
    @MethodSource("getRacingCarName")
    @DisplayName("레이싱카 이동 테스트")
    void 레이싱카_이동_테스트(String carName) {
        UsingNameRacingCar usingNameRacingCar = UsingNameRacingCar.of(carName);

        usingNameRacingCar.move(() -> true);

        assertThat(usingNameRacingCar.getCurrentLocation()).isEqualTo(1);
    }

    static Stream<String> getRacingCarName() {
        return Stream.of("pobi", "gang", "gwal", "gwak");
    }

}