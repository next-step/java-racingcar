package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @DisplayName("1회분 결과 저장")
    @Test
    void create() throws Exception {
        //given
        Cars cars = new Cars("a,b,c", new FixedPowerGenerator());

        //when
        Result result = new Result(cars);

        //then
        assertThat(result.getCars().size()).isEqualTo(3);
    }
}
