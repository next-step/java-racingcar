package car.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.TryCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class InputTest {

    @Test
    @DisplayName("시도 횟수 음수면 예외 처리")
    void 사용자_입력_시도_횟수_예외 () {
        String count = "-1";
        assertThrows(RuntimeException.class, () -> new TryCount(count));
    }

    @Test
    @DisplayName("시도 횟수 정상 동작")
    void 사용자_입력_시도_횟수 () {
        String count = "5";
        TryCount cnt = new TryCount(count);
        assertEquals(5, cnt.getTryCount());
    }
}
