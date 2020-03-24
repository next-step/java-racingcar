package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("입력받은 숫자 List 중 최대 숫자를 잘 고르는 지 테스트")
    void getMaxNumber() {
        List numberList = Arrays.asList(3, 4, 9);
        assertThat(Cars.getMaxPosition(numberList)).isEqualTo(9);
    }
}
