package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Result;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @DisplayName("자동차의 이름을 주면, 현재 Result에서의 자동차의 position값을 반환한다.")
    @Test
    void getCurrentPositionTest() {
        //given
        Map<String, Integer> currentResult = new HashMap<>();
        currentResult.put("mark", 3);
        currentResult.put("jaehyun", 1);
        Result result = new Result(currentResult);

        //when
        int mark = result.getCurrentPosition("mark");
        int jaehyun = result.getCurrentPosition("jaehyun");

        //then
        assertThat(mark).isEqualTo(3);
        assertThat(jaehyun).isEqualTo(1);
    }
}
