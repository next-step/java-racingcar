package car.inputtest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.view.model.Count;
import car.view.InputService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class InputTest {

    @Test
    @DisplayName("car/view")
    void 사용자_이름_테스트_정상 () {
        String carNames = "pobi,crong,honux";
        assertThatCode(()-> InputService.validateCarName(carNames)).doesNotThrowAnyException();
    }
    @ParameterizedTest
    @DisplayName("사용자 이름이 정상적으로 입력 되지 않음")
    @ValueSource(strings = {"", " "})
    void 사용자_이름_테스트_오류(String str) {
        assertThrows(RuntimeException.class, ()-> InputService.validateCarName(str));
    }
    @Test
    @DisplayName("시도 횟수 음수면 예외 처리")
    void 사용자_입력_시도_횟수_예외 () {
        String count = "-1";
        assertThrows(RuntimeException.class, () -> new Count(count));
    }

    @Test
    @DisplayName("시도 횟수 정상 동작")
    void 사용자_입력_시도_횟수 () {
        String count = "5";
        Count cnt = new Count(count);
        assertEquals(5, cnt.getTryCount());
    }
}
