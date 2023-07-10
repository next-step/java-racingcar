package car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.controller.RacingController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest {

    @Test
    @DisplayName("횟수 오류 확인")
    void 횟수_오류_확인() {
        assertThrows(IllegalArgumentException.class,
            () -> new RacingController("jj,jjj", -1).run());
    }

    @Test
    @DisplayName("횟수 정상 컨트롤러 정상 동장")
    void 횟수_오류_정상_동작() {
        assertThatCode(() -> new RacingController("jj ,jjj", 1)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("이름 오류 확인")
    @ValueSource(strings = {"", " aaaaaa, aa"})
    void 이름_오류_확인(String carNames) {
        assertThrows(IllegalArgumentException.class, () -> new RacingController(carNames, 1).run());
    }

    @ParameterizedTest
    @DisplayName("이름 정상 동작 확인")
    @ValueSource(strings = {"aa, ss", "aaaaa, aa"})
    void 이름_정상_동작_확인(String carNames) {
        assertThatCode(() -> new RacingController(carNames, 1)).doesNotThrowAnyException();
    }

}
